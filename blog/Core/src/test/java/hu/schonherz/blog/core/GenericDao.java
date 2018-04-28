package hu.schonherz.blog.core;

import java.util.List;

public interface GenericDao<T> {
	
	Long save(T t);
	
	T update(T t);
	
	void delete(Long i);
	
	List<T> findAll();
	
	T find(Long i);
	
	//a feladat, h ezeket implementaljuk a userdao-ba
}
