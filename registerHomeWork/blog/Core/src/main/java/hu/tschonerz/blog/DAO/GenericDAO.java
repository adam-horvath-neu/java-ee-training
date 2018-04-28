package hu.tschonerz.blog.DAO;

import java.util.List;

public interface GenericDAO<T> {

	Long save(T t) throws Exception;
	
	void update(T t) throws Exception;
	
	void delete(Long id) throws Exception;
	
	List<T> findAll() throws Exception;
	
	T find(Long id) throws Exception;
}
