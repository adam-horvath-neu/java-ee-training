package hu.neuron.service;

import java.util.List;

import hu.neuron.service.vo.UserVo;

public interface UserService {

	UserVo registration(UserVo vo);
	
	UserVo getUserByName(String name);
	
	List<UserVo> findAllUser();

}
