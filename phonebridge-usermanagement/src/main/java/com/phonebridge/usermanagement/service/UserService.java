package com.phonebridge.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.mapper.UserMapper;
import com.phonebridge.usermanagement.model.User;
import com.phonebridge.usermanagement.repository.UserRepository;
import com.phonebridge.usermanagement.utils.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		log.info("inside create user");
		User u = userMapper.UserDTOtoUser(userDto);
		
		User userPersisted = userRepository.save(u);
		return userMapper.userToUserDTO(userPersisted);
		//return userPersisted;
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) {
		Optional<User> optionalUser = userRepository.findById(userDto.getUserId());
		User user = optionalUser.get();
		if (user != null) {
			user = userRepository.save(user);
		}
		return userMapper.userToUserDTO(user);
	}

	@Override
	public UserDTO deleteUser(String id) {
		Optional<User> userReturned = userRepository.findById(id);
		User user = userReturned.get();
		if (user != null) {
			userRepository.delete(user);
		}

		return userMapper.userToUserDTO(user);
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		return userMapper.userListToUserDtoList(userList);
	}

	@Override
	public UserDTO findById(String id) {
		Optional<User> userReturned = userRepository.findById(id);
		User user = userReturned.get();
		return userMapper.userToUserDTO(user);
	}

}
