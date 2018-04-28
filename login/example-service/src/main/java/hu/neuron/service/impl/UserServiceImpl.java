package hu.neuron.service.impl;

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
	public void delete(Long id) {
		UserDao userDao = new UserDaoImpl();
		userDao.delete(id);
		
	}

	/* (non-Javadoc)
	 * @see hu.neuron.service.UserService#findByUserName(java.lang.String)
	 */
	@Override
	public UserVo findByUserName(String userName) {
		UserDao userDao = new UserDaoImpl();
		
		return  UserConverter.toUserVo(userDao.findByName(userName));
	}
	
	

}
