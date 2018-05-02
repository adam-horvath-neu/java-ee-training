package hu.neuron.service;

import java.util.List;

import hu.neuron.service.vo.UserVo;

public interface UserService {

	UserVo registration(UserVo vo);
	void delete(Long id);
	UserVo findByUserName(String userName);
	List<UserVo> findAllElements();
	void update(UserVo t);
	
}
