package hu.schonherz.blog.core;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

public interface GenericDao<T> {

	Long save(T t) throws NamingException, SQLException;

	void update(T t) throws Exception;

	void delete(Long id) throws Exception;

	T find(Long id) throws Exception;

	List<T> findAll() throws Exception;
}
