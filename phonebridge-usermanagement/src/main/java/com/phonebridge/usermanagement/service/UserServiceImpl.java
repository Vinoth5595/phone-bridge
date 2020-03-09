package com.phonebridge.usermanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.exception.InvalidAccountException;
import com.phonebridge.usermanagement.exception.InvalidParameterException;
import com.phonebridge.usermanagement.exception.RecordNotFoundException;
import com.phonebridge.usermanagement.exception.UserAlreadyExistsException;
import com.phonebridge.usermanagement.mapper.UserMapper;
import com.phonebridge.usermanagement.model.User;
import com.phonebridge.usermanagement.repository.AccountRepository;
import com.phonebridge.usermanagement.repository.UserRepository;
import com.phonebridge.usermanagement.utils.CommonUtils;

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
	private UserRepository userRepository; // User repository

	@Autowired
	private AccountRepository accountRepository; // Account Repository

	@Autowired
	private UserMapper userMapper; // User mapper

	/**
	 * To create user
	 * 
	 * @param userDto
	 * @return created user details
	 */
	@Override
	public UserDTO createUser(UserDTO userDto) {
		if (CommonUtils.isBlankOrNull(userDto)) {
			throw new InvalidParameterException("invalid userDto : " + userDto);
		}
		
		User u = userMapper.UserDTOtoUser(userDto);

		if (accountRepository.findByAccountId(u.getAccountId()) == null) {
			throw new InvalidAccountException("Invalid Account");
		}

		if (userRepository.findByAccountIdAndUserName(u.getAccountId(), u.getUserName()) != null) {
			throw new UserAlreadyExistsException("User id is not available.");
		}
		u.setCreatedOn(LocalDateTime.now());
		u.setModifiedOn(LocalDateTime.now());
		User userPersisted = userRepository.save(u);
		return userMapper.userToUserDTO(userPersisted);
	}

	/**
	 * To Update user details
	 *
	 * @param accountId
	 * @param userId
	 * @param userDto
	 * @return updated user details
	 */
	@Override
	public UserDTO updateUserByAccountIdAndUserId(ObjectId accountId, String userId, UserDTO userDto) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		if (CommonUtils.isBlankOrNull(userDto)) {
			throw new InvalidParameterException("invalid userDto : " + userDto);
		}
		
		User optionalUser = userRepository.findByAccountIdAndUserName(accountId, userId);
		if (optionalUser == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		if (userDto.getAccountId() != null && accountRepository.findById(userDto.getAccountId()) == null) {
			throw new InvalidAccountException("Invalid Account id");
		}
		
		User user = userMapper.UserDTOtoUser(userDto);
		user.setUserName(optionalUser.getUserName());
		user.setCreatedOn(optionalUser.getCreatedOn());
		user.setCreatedBy(optionalUser.getCreatedBy());
		user.setModifiedOn(LocalDateTime.now());
		userRepository.save(user);
		return userMapper.userToUserDTO(user);
	}

	/**
	 * To delete a user
	 *
	 * @param id
	 * @return details of the deleted user
	 */
	@Override
	public void deleteUserByAccountIdAndUserId(ObjectId accountId, String userId) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		if (CommonUtils.isBlankOrNull(userId)) {
			throw new InvalidParameterException("invalid userId : " + userId);
		}
		
		User userReturned = userRepository.findByAccountIdAndUserName(accountId, userId);
		if (userReturned == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		userRepository.delete(userReturned);
	}

	/**
	 * To get the list of users.
	 */
	@Override
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		return userMapper.userListToUserDtoList(userList);
	}

	/**
	 * To get the list of users by Account Id.
	 */
	@Override
	public List<UserDTO> findAllByAccountId(ObjectId accountId) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		List<User> userList = userRepository.findByAccountId(accountId);
		return userMapper.userListToUserDtoList(userList);
	}

	/**
	 * To get the user by account id.
	 */
	@Override
	public UserDTO findUserByAccountIdAndUserName(ObjectId accountId, String userId) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		if (CommonUtils.isBlankOrNull(userId)) {
			throw new InvalidParameterException("invalid userId : " + userId);
		}
		
		if (accountRepository.findById(accountId) == null) {
			throw new InvalidAccountException("Invalid Account id");
		}

		User user = userRepository.findByAccountIdAndUserName(accountId, userId);

		if (user == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		return userMapper.userToUserDTO(user);
	}
}
