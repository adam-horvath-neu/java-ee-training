package org.core;

import org.core.RegistrationDTO; 

import java.util.List;

public interface RegistrationDao {


	public Long save(RegistrationDTO dto) throws Exception;

	public void update(RegistrationDTO dto) throws Exception;

	public void delete(Long id) throws Exception;

	public RegistrationDTO find(Long id) throws Exception;

	public List<RegistrationDTO> findAll() throws Exception;
	
	
}
