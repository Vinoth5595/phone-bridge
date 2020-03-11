package com.phonebridge.authserver.service;

import java.util.List;

import com.phonebridge.authserver.row.UserRow;

public interface IUserService {

	UserRow getUserByUserNameAndAccountName(String userName,String accountName);
	
	/**
	 * To create user
	 * 
	 * @param userDto
	 * @return created user details
	 */
	UserRow createUser(UserRow user);

	/**
	 * To Update user details
	 *
	 * @param accountId
	 * @param userId
	 * @param userDto
	 * @return updated user details
	 */
	UserRow updateUser(UserRow userDto);

	/**
	 * To delete a user by account id and user id
	 *
	 * @param accountId
	 * @param userId
	 * @return details of the deleted user
	 */
	//void deleteUser(String accountId, String userId);

	/**
	 * To get the list of users.
	 */
	List<UserRow> findAll();
	
	/**
	 * To get the list of users by Account Id.
	 */
	List<UserRow> findAllByAccountId(String accountId);
}
