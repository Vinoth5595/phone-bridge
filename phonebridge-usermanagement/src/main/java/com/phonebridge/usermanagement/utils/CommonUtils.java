package com.phonebridge.usermanagement.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.mapper.UserMapper;
import com.phonebridge.usermanagement.model.User;

@Component
public class CommonUtils {

//	UserMapper userMapper;
//
//	public List<UserDTO> convertUserListToUserDTOList(List<User> userList) {
//		return userList.stream().map(user -> userMapper.userToUserDTO(user)).collect(Collectors.toList());
//	}
//
//	public List<User> convertUserDTOListToUserList(List<UserDTO> userDtoList) {
//		return userDtoList.stream().map(user -> userMapper.UserDTOtoUser(user)).collect(Collectors.toList());
//	}
}
