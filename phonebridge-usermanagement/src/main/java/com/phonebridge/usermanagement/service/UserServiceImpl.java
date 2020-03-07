package com.phonebridge.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.exception.InvalidAccountException;
import com.phonebridge.usermanagement.exception.RecordNotFoundException;
import com.phonebridge.usermanagement.exception.UserAlreadyExistsException;
import com.phonebridge.usermanagement.mapper.UserMapper;
import com.phonebridge.usermanagement.model.User;
import com.phonebridge.usermanagement.repository.AccountRepository;
import com.phonebridge.usermanagement.repository.UserRepository;

/**
 * Phone Bridge User Management Service
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 02-March-2020
 */

@Service
public class UserServiceImpl implements UserService {
	private static final String NO_RECORDS_FOUND = "Record Not Found";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

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

		if (accountRepository.findByAccountId(u.getAccountId()) == null) {
			throw new InvalidAccountException("Invalid Account");
		}

		if (userRepository.findByAccountIdAndUserId(u.getAccountId(), u.getUserId()) != null) {
			throw new UserAlreadyExistsException("User id is not available.");
		}
		User userPersisted = userRepository.save(u);
		return userMapper.userToUserDTO(userPersisted);
	}

	/**
	 * To Update user details
	 *
	 * @param userId
	 * @return updated user details
	 */
	@Override
	public UserDTO updateUser(String userId, UserDTO userDto) {
		User optionalUser = userRepository.findByUserId(userId);
		if (optionalUser == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		if (userDto.getAccountId() > 0 && accountRepository.findByAccountId(userDto.getAccountId()) == null) {
			throw new InvalidAccountException("Invalid Account");
		}

		User user = userRepository.save(userMapper.UserDTOtoUser(userDto));
		return userMapper.userToUserDTO(user);
	}

	/**
	 * To delete a user
	 *
	 * @param id
	 * @return details of the deleted user
	 */
	@Override
	public void deleteUser(String id) {
		User userReturned = userRepository.findByUserId(id);
		if (userReturned == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		userRepository.delete(userReturned);
	}

	/**
	 * To find the user by Id
	 * 
	 * @param id
	 * @return the user details
	 */
	@Override
	public UserDTO findByUserId(String userId) {
		User userReturned = userRepository.findByUserId(userId);
		if (userReturned == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		if (accountRepository.findByAccountId(userReturned.getAccountId()) == null) {
			throw new InvalidAccountException("Invalid Account");
		}

		if (userRepository.findByAccountIdAndUserId(userReturned.getAccountId(), userReturned.getUserId()) != null) {
			throw new UserAlreadyExistsException("User id is not available.");
		}

		return userMapper.userToUserDTO(userReturned);
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
