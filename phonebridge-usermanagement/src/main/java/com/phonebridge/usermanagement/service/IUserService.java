package com.phonebridge.usermanagement.service;

import java.util.List;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.model.User;

public interface IUserService {

	UserDTO createUser(UserDTO user);

	UserDTO updateUser(UserDTO userDto);

	UserDTO deleteUser(String id);

	List<UserDTO> findAll();

	UserDTO findById(String id);
}
