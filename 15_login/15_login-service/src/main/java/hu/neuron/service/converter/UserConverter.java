package hu.neuron.service.converter;

import java.util.ArrayList;
import java.util.List;

import hu.neuron.core.dto.UserDTO;
import hu.neuron.service.vo.UserVO;

public class UserConverter {
	public static UserVO toUserVO(UserDTO dto) {
		if (dto == null) {
			return null;
		}
		UserVO userVO = new UserVO();
		userVO.setId(dto.getId());
		userVO.setUsername(dto.getUsername());
		userVO.setPassword(dto.getPassword());
		userVO.setFirstname(dto.getFirstname());
		userVO.setLastname(dto.getLastname());
		userVO.setUrl(dto.getUrl());
		userVO.setEmail(dto.getEmail());
		userVO.setPhone(dto.getPhone());

		
		//RoleDAO roleDAO = new RoleDAOImpl();
		//List <RoleDTO> roles = roleDAO.findRolesByUser(dto.getId());
		//userVO.setRoles(roles);
		
		return userVO;
	}
	
	public static UserDTO toUserDTO(UserVO vo) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(vo.getId());
		userDTO.setPassword(vo.getPassword());
		userDTO.setUsername(vo.getUsername());
		userDTO.setFirstname(vo.getFirstname());
		userDTO.setLastname(vo.getLastname());
		userDTO.setUrl(vo.getUrl());
		userDTO.setEmail(vo.getEmail());
		userDTO.setPhone(vo.getPhone());
		
		return userDTO;
	}
	
	public static List<UserVO> toUserVOList(List<UserDTO> dto_list){
		List<UserVO> vo_list = new ArrayList<>();
		for(UserDTO dto : dto_list) {
			UserVO userVO = new UserVO();
			userVO.setId(dto.getId());
			userVO.setUsername(dto.getUsername());
			userVO.setPassword(dto.getPassword());
			userVO.setFirstname(dto.getFirstname());
			userVO.setLastname(dto.getLastname());
			userVO.setUrl(dto.getUrl());
			userVO.setEmail(dto.getEmail());
			userVO.setPhone(dto.getPhone());
			vo_list.add(userVO);
		}
		
		return vo_list;
	}
	
	
}