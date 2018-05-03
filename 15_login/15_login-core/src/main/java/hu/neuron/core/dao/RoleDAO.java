package hu.neuron.core.dao;

import java.util.List;

import hu.neuron.core.dto.RoleDTO;

public interface RoleDAO extends GenericDAO<RoleDTO>{
	
	List<RoleDTO>findRolesByUser(Long id);
	
}
