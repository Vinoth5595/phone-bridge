package com.phonebridge.authserver.db.mongo.v1.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phonebridge.authserver.db.mongo.v1.row.DBRowUser;

/**
 * Phone Bridge user repository
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@Repository
public interface UserRepository extends MongoRepository<DBRowUser, String> {

	/**
	 * To get user by id
	 * 
	 * @param userId
	 * @return
	 */
	DBRowUser findByUserName(String userId);

	/**
	 * To get list of user by account id
	 * 
	 * @param userId
	 * @return
	 */
	List<DBRowUser> findByAccountId(String accountId);

	/**
	 * To get user by account id and user id
	 * 
	 * @param accountId
	 * @param userId
	 * @return
	 */
	DBRowUser findByAccountNameAndUserName(String accountName, String userName);
	
	DBRowUser findByIdAndAccountId(String id, String accountId);
}
