package hu.neuron.pizza.core.dao;

import java.util.List;

import hu.neuron.pizza.core.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

	Long save(E e);

	E find(Long id);

	void update(E e);

	void remove(Long id);

	List<E> findall();
}
