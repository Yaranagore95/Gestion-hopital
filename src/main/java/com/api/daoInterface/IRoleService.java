package com.api.daoInterface;

import java.util.List;

import com.api.model.Role;
import com.api.model.Utilisateur;
import com.api.modelDto.RoleDto;

public interface IRoleService {
	Role save(RoleDto role);
	List<Role> findAll();
	void delete(int id);
	Role getById(int id);
	RoleDto update(RoleDto roleDto);
	List<Utilisateur> allUser(int id);
}
