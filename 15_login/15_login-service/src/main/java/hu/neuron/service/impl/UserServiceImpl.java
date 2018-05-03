package hu.neuron.service.impl;

import java.util.List;

import hu.neuron.core.dao.UserDAO;
import hu.neuron.core.dao.impl.UserDAOImpl;
import hu.neuron.core.dto.UserDTO;
import hu.neuron.service.UserService;
import hu.neuron.service.converter.UserConverter;
import hu.neuron.service.vo.UserVO;

public class UserServiceImpl implements UserService{

	@Override
	public UserVO registration(UserVO vo) {
		UserDAO userDao = new UserDAOImpl();
		
		//Long id = userDao.save(UserConverter.toUserDTO(vo));
		//userDao.find(id);
		userDao.save(UserConverter.toUserDTO(vo));
		return vo;
	}

	@Override
	public List<UserVO> getAllUsers() {
		UserDAO userDao = new UserDAOImpl();
		List<UserDTO> list = userDao.findAll();
		return UserConverter.toUserVOList(list);
	}

	@Override
	public UserVO updateUser(UserVO vo) {
		UserDAO userDao = new UserDAOImpl();
		return UserConverter.toUserVO(userDao.update(UserConverter.toUserDTO(vo))) ;
	
	}

	@Override
	public void deleteUser(Long id) {
		UserDAO userDao = new UserDAOImpl();
		userDao.delete(id);
	}

	@Override
	public UserVO getUserById(Long id) {
		UserDAO userDao = new UserDAOImpl();
		return UserConverter.toUserVO(userDao.find(id));
		
	}

}
