package hu.neuron.service.impl;


import java.util.ArrayList;
import java.util.List;

import hu.neuron.core.dao.UserDao;
import hu.neuron.core.dao.impl.UserDaoImpl;
import hu.neuron.core.dto.UserDto;
import hu.neuron.service.UserService;
import hu.neuron.service.converter.UserConverter;
import hu.neuron.service.vo.UserVo;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public UserVo registration(UserVo vo) {
		UserDao userDao = new UserDaoImpl();
		Long id = userDao.save(UserConverter.toUserDto(vo));
		// userDao.find(id);
		return vo;
	}

	@Override
	public UserVo findByUsername(String name) {
		userDao = new UserDaoImpl();

		UserDto userDto = userDao.findByName(name);

		return UserConverter.toUserVo(userDto);
	}

	@Override
	public List<UserVo> findAll() {
		userDao = new UserDaoImpl();
		
		List<UserVo> resultList = new ArrayList<>();
		
		for (UserDto dto : userDao.findAll()) {
			resultList.add(UserConverter.toUserVo(dto));
		}
		return resultList;
	}

	@Override
	public void delete(Long id) {
		userDao = new UserDaoImpl();
		
		userDao.delete(id);
		
	}	

}
