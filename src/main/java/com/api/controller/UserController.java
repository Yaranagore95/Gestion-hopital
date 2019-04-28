package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.daoInterface.IUtilisateurService;
import com.api.model.Role;
import com.api.model.Utilisateur;
import com.api.modelDto.RoleDto;
import com.api.modelDto.UtilisateurDto;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/API")
public class UserController {
	@Autowired
    private IUtilisateurService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<Utilisateur> listUser(){
    	for (Utilisateur u : userService.findAll()) {
			System.out.println("User : "+u.getId());
		}
        return userService.findAll();
    }

    //@Secured("ROLE_USER")
    //@PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Utilisateur getOne(@PathVariable(value = "id") int id){
        return userService.getById(id);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public Utilisateur create(@RequestBody UtilisateurDto user){
    	for (RoleDto r : user.getRole()) {
			System.out.println("role="+r.getLibelle());
		}
        return userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user-delete/{id}", method = RequestMethod.DELETE)
    public Utilisateur deleteUser(@PathVariable(value = "id") int id){
        userService.delete(id);
        return new Utilisateur(id);
    }
    
    

}
