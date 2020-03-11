package com.phonebridge.authserver.db.mongo.v1.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phonebridge.authserver.db.mongo.v1.row.DBRowAccount;

/**
 * Phone Bridge account repository
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@Repository
public interface AccountRepository extends MongoRepository<DBRowAccount, String> {
	
	public List<DBRowAccount> findByAccountName(String accountName);
	
}
