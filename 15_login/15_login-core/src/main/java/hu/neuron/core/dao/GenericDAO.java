package hu.neuron.core.dao;

import java.util.List;

public interface GenericDAO<T> {
	Long save(T t);
	void delete(Long id);
	T update(T t);
	T find(Long id);
	List<T> findAll();
}
