package hu.neuron.pizza.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import hu.neuron.pizza.core.dao.RoleDao;
import hu.neuron.pizza.core.dao.UserDao;
import hu.neuron.pizza.core.entity.Role;
import hu.neuron.pizza.core.entity.User;
import hu.neuron.pizza.service.UserServiceLocal;
import hu.neuron.pizza.service.UserServiceRemote;
import hu.neuron.pizza.service.mapper.RoleMapper;
import hu.neuron.pizza.service.mapper.UserMapper;
import hu.neuron.pizza.service.vo.RoleVo;
import hu.neuron.pizza.service.vo.UserVo;

@Stateless
@Local(UserServiceLocal.class)
@Remote(UserServiceRemote.class)
public class UserServiceBean implements UserServiceLocal, UserServiceRemote {

	@EJB
	private UserDao userDao;

	@EJB
	private RoleDao roleDao;

	private UserMapper usermapper;
	
	private RoleMapper rolemapper;

	@PostConstruct // poololt: hívások gyakoriságától függ hány példányban él és mindig lefut az összes példányra
	public void init() {
		usermapper = new UserMapper();
		rolemapper = new RoleMapper();
	}

	@Override
	public Long addUser(UserVo vo) {
		return userDao.save(usermapper.toEntity(vo));
	}

	@Override
	public void addRoleToUser(UserVo user, RoleVo role) {
		User userEntity = usermapper.toEntity(user);
		List<Role> roles = userEntity.getRoles();
		if (roles == null) {
			roles= new ArrayList<>();
		}
		roles.add(rolemapper.toEntity(role));
		userDao.update(userEntity);
	}

	@Override
	public void removeRoleFromUser(UserVo user, RoleVo role) {
		User userEntity = usermapper.toEntity(user);
		List<Role> roles = userEntity.getRoles();
		roles.remove(rolemapper.toEntity(role));
		userDao.update(userEntity);
	}

	@Override
	public void removeUser(Long id) {
		userDao.remove(id);
	}

	@Override
	public List<UserVo> getAllUsers() {
		return usermapper.toVo(userDao.findall());
	}

}
