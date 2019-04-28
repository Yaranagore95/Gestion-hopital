package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.daoInterface.IRoleService;
import com.api.model.Role;
import com.api.modelDto.RoleDto;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("API")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value="/roles",method= RequestMethod.GET)
	public List<Role> getRoles() {
		return roleService.findAll();
	}
	
	@RequestMapping(value="/addRole",method= RequestMethod.POST)
	public Role addRole(@RequestBody RoleDto role) {
		return roleService.save(role);
	}
	
	@RequestMapping(value="/role/{id}",method=RequestMethod.GET)
	public Role getOne(@PathVariable(value="id") int id) {
		return roleService.getById(id);
	}
}
