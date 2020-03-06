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
	 * @param userDto
	 * @return updated user details
	 */
	UserDTO updateUser(UserDTO userDto);

	/**
	 * To delete a user
	 *
	 * @param id
	 * @return details of the deleted user
	 */
	UserDTO deleteUser(String id);

	/**
	 * To get the list of users.
	 */
	List<UserDTO> findAll();

	/**
	 * To find the user by Id
	 * 
	 * @param id
	 * @return the user details
	 */
	UserDTO findById(String id);
}
