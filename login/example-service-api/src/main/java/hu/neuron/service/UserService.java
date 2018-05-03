package hu.neuron.service;

import java.util.List;

import hu.neuron.service.vo.UserVo;

public interface UserService {

	UserVo registration(UserVo vo);
	
	public List<UserVo> getAllUsers();
	
	public void update(UserVo vo);

	void delete(UserVo vo);
}
