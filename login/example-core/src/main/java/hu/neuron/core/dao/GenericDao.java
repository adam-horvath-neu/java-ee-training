package hu.neuron.core.dao;

import java.util.List;

import hu.neuron.core.dto.UserDto;

public interface GenericDao<T> {

	Long save(T t);

	void delete(Long id);

	T find(Long id);

	List<T> findAll();

	void update(UserDto t);
}
