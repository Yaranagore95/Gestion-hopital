package com.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.daoInterface.RoleDao;
import com.api.daoInterface.UtilisateurDao;
import com.api.model.Role;
import com.api.model.Utilisateur;

@SpringBootApplication
public class GestionHopitalApplication implements CommandLineRunner {

	@Autowired
	RoleDao roleDao;
	
	@Autowired 
	UtilisateurDao utilisateurDao;
	
	@Autowired
	BCryptPasswordEncoder cryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionHopitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Role> roles = new ArrayList<>();
		Role r = new Role();
		r.setId(1);r.setLibelle("ADMIN");
		roles.add(r);
		r = new Role();
		r.setId(2);r.setLibelle("USER");
		roles.add(r);
		r = new Role();
		r.setId(3);r.setLibelle("MEDECIN");
		roles.add(r);
		roleDao.saveAll(roles);
		Utilisateur u = new Utilisateur();
		u.setChanged(false);
		u.setEnabled(true);
		u.setId(1);
		u.setMatricule("mat001");
		u.setNom("Baba");
		u.setPhoto("");
		u.setPrenom("Yara");
		u.setRoles(roles);
		u.setUsername("baba2018");
		u.setPassword(cryptPasswordEncoder.encode("passer2018"));
		utilisateurDao.save(u);
		
	}

}
