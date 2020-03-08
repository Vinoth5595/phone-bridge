package com.phonebridge.usermanagement.service;

import java.util.List;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.model.User;

/**
* Phone Bridge User Management Service 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

public interface UserService {

	/**
	 * To create user
	 * 
	 * @param userDto
	 * @return created user details
	 */
	UserDTO createUser(UserDTO user);

	/**
	 * To Update user details
	 *
	 * @param accountId
	 * @param userId
	 * @param userDto
	 * @return updated user details
	 */
	UserDTO updateUserByAccountIdAndUserId(int accountId, String userId, UserDTO userDto);

	/**
	 * To delete a user by account id and user id
	 *
	 * @param accountId
	 * @param userId
	 * @return details of the deleted user
	 */
	void deleteUserByAccountIdAndUserId(int accountId, String userId);

	/**
	 * To get the list of users.
	 */
	List<UserDTO> findAll();
	
	/**
	 * To get the user by account id.
	 */
	UserDTO findUserByAccountIdAndUserId(int accountId, String userId);
	
	/**
	 * To get the list of users by Account Id.
	 */
	List<UserDTO> findAllByAccountId(int accountId);
}
