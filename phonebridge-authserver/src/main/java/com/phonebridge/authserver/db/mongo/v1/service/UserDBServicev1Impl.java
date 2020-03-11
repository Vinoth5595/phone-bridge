package com.phonebridge.authserver.db.mongo.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.phonebridge.authserver.db.mongo.v1.mapper.DBUserMapper;
import com.phonebridge.authserver.db.mongo.v1.repository.AccountRepository;
import com.phonebridge.authserver.db.mongo.v1.repository.UserRepository;
import com.phonebridge.authserver.db.mongo.v1.row.DBRowUser;
import com.phonebridge.authserver.exception.InvalidAccountException;
import com.phonebridge.authserver.exception.InvalidParameterException;
import com.phonebridge.authserver.exception.RecordNotFoundException;
import com.phonebridge.authserver.exception.UserAlreadyExistsException;
import com.phonebridge.authserver.row.UserRow;
import com.phonebridge.authserver.service.IUserService;
import com.phonebridge.authserver.utils.CommonUtils;

@Service
public class UserDBServicev1Impl implements IUserService {

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String NO_RECORDS_FOUND = "Record Not Found";

	@Autowired
	private UserRepository userRepository; // User repository

	@Autowired
	private AccountRepository accountRepository; // Account Repository

	@Autowired
	private DBUserMapper dbUserMapper; // User mapper

	/**
	 * To create user
	 * 
	 * @param userRow
	 * @return created user details
	 */
	@Override
	public UserRow createUser(UserRow userRow) {
		if (CommonUtils.isBlankOrNull(userRow)) {
			throw new InvalidParameterException("invalid userDto : " + userRow);
		}

		DBRowUser dbUser = dbUserMapper.userRowtoDBUserRow(userRow);

		if (accountRepository.findByAccountName(dbUser.getAccountName()).isEmpty()) {
			throw new InvalidAccountException("Invalid Account");
		}

		if (userRepository.findByAccountNameAndUserName(dbUser.getAccountName(), dbUser.getUserName()) != null) {
			throw new UserAlreadyExistsException("User id is not available.");
		}
		DBRowUser userPersisted = userRepository.save(dbUser);
		return dbUserMapper.dbUserRowtoUserRow(userPersisted);
	}

	/**
	 * To Update user details
	 *
	 * @param accountId
	 * @param userId
	 * @param userRow
	 * @return updated user details
	 */
	@Override
	public UserRow updateUser(UserRow userRow) {

		if (CommonUtils.isBlankOrNull(userRow)) {
			throw new InvalidParameterException("invalid userDto : " + userRow);
		}
		if (CommonUtils.isBlankOrNull(userRow.getAccountId())) {
			throw new InvalidParameterException("invalid accountId : " + userRow.getAccountId());
		}

		DBRowUser fetchedDbUser = userRepository.findByIdAndAccountId(userRow.getId(), userRow.getAccountId());
		if (fetchedDbUser == null) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		DBRowUser givenDbUser = dbUserMapper.userRowtoDBUserRow(userRow);
		DBRowUser result = userRepository.save(givenDbUser);
		return dbUserMapper.dbUserRowtoUserRow(result);
	}

	/**
	 * To delete a user
	 *
	 * @param id
	 * @return details of the deleted user
	 *//*
		 * @Override public void deleteUserByAccountIdAndUserId(ObjectId accountId,
		 * String userId) { if (CommonUtils.isBlankOrNull(accountId)) { throw new
		 * InvalidParameterException("invalid accountId : " + accountId); }
		 * 
		 * if (CommonUtils.isBlankOrNull(userId)) { throw new
		 * InvalidParameterException("invalid userId : " + userId); }
		 * 
		 * User userReturned = userRepository.findByAccountIdAndUserName(accountId,
		 * userId); if (userReturned == null) { throw new
		 * RecordNotFoundException(NO_RECORDS_FOUND); }
		 * 
		 * userRepository.delete(userReturned); }
		 */

	/**
	 * To get the list of users.
	 */
	@Override
	public List<UserRow> findAll() {
		List<DBRowUser> userList = userRepository.findAll();
		return dbUserMapper.dbUserRowLstToUserRowList(userList);
	}

	/**
	 * To get the list of users by Account Id.
	 */
	@Override
	public List<UserRow> findAllByAccountId(String accountId) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}

		List<DBRowUser> dbUserList = userRepository.findByAccountId(accountId);
		return dbUserMapper.dbUserRowLstToUserRowList(dbUserList);
	}

	public UserRow getUserByUserNameAndAccountName(String userName, String accountName) {
		Query query = new Query().addCriteria(Criteria.where("userName").is(userName))
				.addCriteria(Criteria.where("accountName").is(accountName));
		return DBUserUtils.convertDBRowUserToUser(mongoTemplate.findOne(query, DBRowUser.class));
	}

}
