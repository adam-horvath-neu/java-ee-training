package hu.neuron.service.converter;

import hu.neuron.core.dto.UserDto;
import hu.neuron.service.vo.UserVo;

public class UserConverter {

	public static UserVo toUserVo(UserDto dto) {
		if (dto == null) {
			return null;
		}
		UserVo userVo = new UserVo();
		userVo.setUsername(dto.getUsername());
		userVo.setFirstname(dto.getFirstname());
		userVo.setLastname(dto.getLastname());
		userVo.setUrl(dto.getUrl());
		userVo.setPassword(dto.getPassword());
		userVo.setEmail(dto.getEmail());
		userVo.setPhone(dto.getPhone());
		userVo.setId(dto.getId());

		// RoleDao roleDao = new RoleDaoImpl();

		// List<RoleDto> roles = roleDao.findRolesByUser(dto.getId());
		// userVo.setRoles(roles);
		return userVo;
	}

	public static UserDto toUserDto(UserVo vo) {
		UserDto userDto = new UserDto();
		userDto.setId(vo.getId());
		userDto.setUsername(vo.getUsername());
		userDto.setFirstname(vo.getFirstname());
		userDto.setLastname(vo.getLastname());
		userDto.setUrl(vo.getUrl());
		userDto.setPassword(vo.getPassword());
		userDto.setEmail(vo.getEmail());
		userDto.setPhone(vo.getPhone());
		return userDto;
	}
}
