package hu.neuron.service;

import java.util.List;

import hu.neuron.service.vo.UserVO;

public interface UserService {
	UserVO registration(UserVO vo);
	List<UserVO> getAllUsers();
	UserVO updateUser(UserVO vo);
	void deleteUser(Long id);
	UserVO getUserById(Long id);
}
