package hu.neuron.service.converter;

import java.util.List;

import hu.neuron.core.dao.RoleDao;
import hu.neuron.core.dao.impl.RoleDaoImpl;
import hu.neuron.core.dto.RoleDto;
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
		userVo.setFirstName(dto.getFirstName());
		userVo.setLastName(dto.getLastName());
		userVo.setPhoneNumber(dto.getPhoneNumber());
		userVo.setPictureUrl(dto.getPictureUrl());
		userVo.setUserEmail(dto.getUserEmail());
		userVo.setId(dto.getId());

		return userVo;
	}

	public static UserDto toUserDto(UserVo vo) {
		UserDto userDto = new UserDto();
		userDto.setId(vo.getId());
		userDto.setPassword(vo.getPassword());
		userDto.setUsername(vo.getUsername());
		userDto.setFirstName(vo.getFirstName());
		userDto.setLastName(vo.getLastName());
		userDto.setPhoneNumber(vo.getPhoneNumber());
		userDto.setPictureUrl(vo.getPictureUrl());
		userDto.setUserEmail(vo.getUserEmail());
		return userDto;
	}
}
