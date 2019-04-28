package com.api.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.daoInterface.IUtilisateurService;
import com.api.daoInterface.UtilisateurDao;
import com.api.model.Consultation;
import com.api.model.Role;
import com.api.model.Utilisateur;
import com.api.modelDto.RoleDto;
import com.api.modelDto.UtilisateurDto;

@Service(value="utilisateurService")
public class UtilisateurServiceImpl implements UserDetailsService, IUtilisateurService{
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	RoleServiceImpl roleService;
	
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurDao.findByUsername(username);
		if (utilisateur == null) {
			throw new UsernameNotFoundException("Sorry User not found");
		}
		for (Role r : utilisateur.getRoles()) {
			System.out.println("role : "+r.getLibelle());
		}
		return new org.springframework.security.core.userdetails.User(utilisateur.getUsername(),utilisateur.getPassword(),getAuthority(utilisateur));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Set getAuthority(Utilisateur user) {
        Set authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getLibelle()));
		});
		for (Object object : authorities) {
			System.out.println("valeur = "+object);
		}
		return authorities;
	}
	
	@Override
	public Utilisateur save(UtilisateurDto utilisateur) {
		Utilisateur newUtilisateur = new Utilisateur(utilisateur.getId());
		newUtilisateur.setNom(utilisateur.getNom());
		newUtilisateur.setPrenom(utilisateur.getPrenom());
		newUtilisateur.setPassword(bcryptEncoder.encode(utilisateur.getPassword()));
		newUtilisateur.setUsername(utilisateur.getUsername());
		newUtilisateur.setPhoto(utilisateur.getPhoto());
		newUtilisateur.setEnabled(utilisateur.getEnabled());
		newUtilisateur.setMatricule(utilisateur.getMatricule());
		newUtilisateur.setChanged(utilisateur.getChanged());
		List<Role> userRole = new ArrayList<>();
		for (RoleDto role : utilisateur.getRole()) {
			userRole.add(roleService.save(role));
		}
		newUtilisateur.setRoles(userRole);
		return utilisateurDao.save(newUtilisateur);
	}

	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> list = new ArrayList<>();
		utilisateurDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		utilisateurDao.deleteById(id);
	}

	@Override
	public Utilisateur findOne(String username) {
		return utilisateurDao.findByUsername(username);
	}

	@Override
	public Utilisateur getById(int id) {
		Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);
		return optionalUtilisateur.isPresent() ? optionalUtilisateur.get() : null;
	}

	@Override
	public UtilisateurDto update(UtilisateurDto utilisateurDto) {
		Utilisateur utilisateur = utilisateurDao.findByUsername(utilisateurDto.getUsername());
		if (utilisateur != null) {
			BeanUtils.copyProperties(utilisateurDto, utilisateur,"password");
		}
		return utilisateurDto;
	}

	@Override
	public List<Consultation> allConsultation(int id) {
		List<Consultation> allConsultation = new ArrayList<>();
		this.getById(id).getConsultations().iterator().forEachRemaining(allConsultation::add);
		return allConsultation;
	}


	@Override
	public List<Role> allRole(int id) {
		List<Role> allRole = new ArrayList<>();
		this.getById(id).getRoles().iterator().forEachRemaining(allRole::add);
		return allRole;
	}

}
