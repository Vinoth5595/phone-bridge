package com.phonebridge.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phonebridge.usermanagement.model.User;

/**
 * Phone Bridge user repository
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * To get user by id
	 * 
	 * @param userId
	 * @return
	 */
	User findByUserId(String userId);

	/**
	 * To get user by account id and user id
	 * 
	 * @param accountId
	 * @param userId
	 * @return
	 */
	User findByAccountIdAndUserId(int accountId, String userId);
}
