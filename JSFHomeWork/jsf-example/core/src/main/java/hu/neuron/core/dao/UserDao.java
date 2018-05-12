package hu.neuron.core.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import hu.neuron.core.dto.UserDto;

public interface UserDao extends GenericDao<UserDto> {

	UserDto findByName(String name);

	List<UserDto> getUserList(int first, int pageSize, String sortField, String name, Map<String, Object> filters);
}
