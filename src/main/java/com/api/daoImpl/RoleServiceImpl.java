package com.api.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.daoInterface.IRoleService;
import com.api.daoInterface.RoleDao;
import com.api.model.Role;
import com.api.model.Utilisateur;
import com.api.modelDto.RoleDto;

@Service(value="roleService")
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleDao roleRep;
	
	@Override
	public Role save(RoleDto role) {
		Role newRole = new Role();
		newRole.setId(role.getId());
		newRole.setLibelle(role.getLibelle());
		return roleRep.save(newRole);
	}

	@Override
	public List<Role> findAll() {
		List<Role> listRole = new ArrayList<>();
		roleRep.findAll().iterator().forEachRemaining(listRole::add);
		return listRole;
	}

	@Override
	public void delete(int id) {
		roleRep.deleteById(id);
	}

	@Override
	public Role getById(int id) {
		Optional<Role> optionalRole = roleRep.findById(id);
		return optionalRole.isPresent() ? optionalRole.get() : null;
	}

	@Override
	public RoleDto update(RoleDto roleDto) {
		Role roleUpdate = roleRep.getOne(roleDto.getId());
		if (roleUpdate != null) {
			BeanUtils.copyProperties(roleUpdate, roleDto);
		}
		return roleDto;
	}

	@Override
	public List<Utilisateur> allUser(int id) {
		List<Utilisateur> allUtilisateur = new ArrayList<>();
		this.getById(id).getUtilisateurs().iterator().forEachRemaining(allUtilisateur::add);
		return allUtilisateur;
	}

}
