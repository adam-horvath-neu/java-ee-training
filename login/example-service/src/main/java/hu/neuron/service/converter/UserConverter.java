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
		userVo.setEmail(dto.getEmail());
		userVo.setPhone(dto.getPhone());
		return userVo;
	}

	public static UserDto toUserDto(UserVo vo) {
		UserDto userDto = new UserDto();
		userDto.setId(vo.getId());
		userDto.setPassword(vo.getPassword());
		userDto.setUsername(vo.getUsername());
		userDto.setFirstname(vo.getFirstname());
		userDto.setLastname(vo.getLastname());
		userDto.setEmail(vo.getEmail());
		userDto.setPhone(vo.getPhone());

		return userDto;
	}
}
