package hu.neuron.core.dao;

import hu.neuron.core.dto.UserDTO;

public interface UserDAO extends GenericDAO<UserDTO>{

	UserDTO findByName(String name);
}
