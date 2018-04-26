package hu.schonherz.blog.core.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

public interface GenericDao<T> {

	void update(T t) throws Exception;
	void delete(Long id) throws Exception;
	T find(Long id) throws Exception;
	Long save(T t) throws NamingException, SQLException;
	List<T> findAll() throws Exception;
	
}
