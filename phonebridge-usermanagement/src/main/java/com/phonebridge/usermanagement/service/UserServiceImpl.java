package com.phonebridge.usermanagement.service;

import java.time.LocalDateTime;
import java.util.List;

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
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	CommonUtils commonUtils;

	/**
	 * To create user
	 * 
	 * @param userDto
	 * @return created user details
	 */
	@Override
	public UserDTO createUser(UserDTO userDto) {
		if (commonUtils.isBlankOrNull(userDto)) {
			throw new InvalidParameterException("invalid userDto : " + userDto);
		}
		
		User u = userMapper.UserDTOtoUser(userDto);

		if (accountRepository.findByAccountId(u.getAccountId()) == null) {
			throw new InvalidAccountException("Invalid Account");
		}

		if (userRepository.findByAccountIdAndUserId(u.getAccountId(), u.getUserId()) != null) {
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
	public UserDTO updateUserByAccountIdAndUserId(int accountId, String userId, UserDTO userDto) {
		if (commonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		if (commonUtils.isBlankOrNull(userDto)) {
			throw new InvalidParameterException("invalid userDto : " + userDto);
		}
		
		User optionalUser = userRepository.findByAccountIdAndUserId(accountId, userId);
		if (optionalUser == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		if (userDto.getAccountId() > 0 && accountRepository.findByAccountId(userDto.getAccountId()) == null) {
			throw new InvalidAccountException("Invalid Account id");
		}
		
		User user = userMapper.UserDTOtoUser(userDto);
		user.setPbId(optionalUser.getPbId());
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
	public void deleteUserByAccountIdAndUserId(int accountId, String userId) {
		if (commonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		if (commonUtils.isBlankOrNull(userId)) {
			throw new InvalidParameterException("invalid userId : " + userId);
		}
		
		User userReturned = userRepository.findByAccountIdAndUserId(accountId, userId);
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
	public List<UserDTO> findAllByAccountId(int accountId) {
		if (commonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		List<User> userList = userRepository.findByAccountId(accountId);
		return userMapper.userListToUserDtoList(userList);
	}

	/**
	 * To get the user by account id.
	 */
	@Override
	public UserDTO findUserByAccountIdAndUserId(int accountId, String userId) {
		if (commonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		if (commonUtils.isBlankOrNull(userId)) {
			throw new InvalidParameterException("invalid userId : " + userId);
		}
		
		if (accountRepository.findByAccountId(accountId) == null) {
			throw new InvalidAccountException("Invalid Account id");
		}

		User user = userRepository.findByAccountIdAndUserId(accountId, userId);

		if (user == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		return userMapper.userToUserDTO(user);
	}
}
