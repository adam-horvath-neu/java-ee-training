package hu.neuron.service;

import java.util.List;

import hu.neuron.service.vo.UserVo;

public interface UserService {

	UserVo registration(UserVo vo);

	UserVo findByUsername(String name);

	List<UserVo> findAll();

	void delete(Long id);
	
	void update(UserVo vo);
}
