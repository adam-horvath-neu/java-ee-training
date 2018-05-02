package hu.neuron.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hu.neuron.core.dao.UserDao;
import hu.neuron.core.dao.impl.UserDaoImpl;
import hu.neuron.core.dto.UserDto;
import hu.neuron.service.UserService;
import hu.neuron.service.converter.UserConverter;
import hu.neuron.service.vo.UserVo;

public class UserServiceImpl implements UserService {

	@Override
	public UserVo registration(UserVo vo) {
		UserDao userDao = new UserDaoImpl();

		Long id = userDao.save(UserConverter.toUserDto(vo));
		// userDao.find(id);
		return vo;
	}

	@Override
	public UserVo getUserByName(String name) {
		UserDao userDao = new UserDaoImpl();

		UserDto userDto = userDao.findByName(name);

		return UserConverter.toUserVo(userDto);
	}

	@Override
	public List<UserVo> findAllUser() {
		UserDao userDao = new UserDaoImpl();

		List<UserDto> userDtoList = userDao.findAll();
		List<UserVo> users = new ArrayList<>();
		for (UserDto userDto : userDtoList) {
			users.add(UserConverter.toUserVo(userDto));
		}

		return users;
	}

}
