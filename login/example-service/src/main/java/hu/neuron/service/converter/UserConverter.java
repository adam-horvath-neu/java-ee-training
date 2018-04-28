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
		userVo.setPassword(dto.getPassword());
		userVo.setId(dto.getId());
		userVo.setFirstname(dto.getFirstname());
		userVo.setLastname(dto.getLastname());
		userVo.setPhone(dto.getPhone());
		userVo.setUrl(dto.getUrl());
		userVo.setEmail(dto.getEmail());

		// RoleDao roleDao = new RoleDaoImpl();

		// List<RoleDto> roles = roleDao.findRolesByUser(dto.getId());
		// userVo.setRoles(roles);
		return userVo;
	}

	public static UserDto toUserDto(UserVo vo) {
		if (vo == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		userDto.setId(vo.getId());
		userDto.setPassword(vo.getPassword());
		userDto.setUsername(vo.getUsername());
		userDto.setFirstname(vo.getFirstname());
		userDto.setLastname(vo.getLastname());
		userDto.setPhone(vo.getPhone());
		userDto.setUrl(vo.getUrl());
		userDto.setEmail(vo.getEmail());
		return userDto;
	}
}
