package hu.neuron.service;


import hu.neuron.service.vo.UserVo;

public interface UserService {

	UserVo registration(UserVo vo);
	
	void delete(Long id);
	
	UserVo findByUserName(String userName);
	
}
