package com.phonebridge.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.exception.RecordNotFoundException;
import com.phonebridge.usermanagement.mapper.UserMapper;
import com.phonebridge.usermanagement.model.User;
import com.phonebridge.usermanagement.repository.UserRepository;

/**
* Phone Bridge User Management Service 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   02-March-2020 
*/

@Service
public class UserService implements IUserService {
	private static final String NO_RECORDS_FOUND="Record Not Found";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	/**
	 * To create user
	 * 
	 * @param userDto
	 * @return created user details
	 */
	@Override
	public UserDTO createUser(UserDTO userDto) {
		User u = userMapper.UserDTOtoUser(userDto);
		User userPersisted = userRepository.save(u);
		return userMapper.userToUserDTO(userPersisted);
	}

	/**
	 * To Update user details
	 *
	 * @param userDto
	 * @return updated user details
	 */
	@Override
	public UserDTO updateUser(UserDTO userDto) {
		Optional<User> optionalUser = userRepository.findById(userDto.getUserId());
		if (!optionalUser.isPresent()) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		} else {
			User user = optionalUser.get();
			if (user != null) {
				user = userRepository.save(user);
			}
			return userMapper.userToUserDTO(user);
		}
	}

	/**
	 * To delete a user
	 *
	 * @param id
	 * @return details of the deleted user
	 */
	@Override
	public UserDTO deleteUser(String id) {
		Optional<User> userReturned = userRepository.findById(id);
		if (!userReturned.isPresent()) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		} else {
			User user = userReturned.get();
			if (user != null) {
				userRepository.delete(user);
			}
			return userMapper.userToUserDTO(user);
		}
	}

	/**
	 * To find the user by Id
	 * 
	 * @param id
	 * @return the user details
	 */
	@Override
	public UserDTO findById(String id) {
		Optional<User> userReturned = userRepository.findById(id);
		if (!userReturned.isPresent()) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		} else {
			User user = userReturned.get();
			return userMapper.userToUserDTO(user);
		}
	}
	
	/**
	 * To get the list of users.
	 */
	@Override
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		return userMapper.userListToUserDtoList(userList);
	}

}
