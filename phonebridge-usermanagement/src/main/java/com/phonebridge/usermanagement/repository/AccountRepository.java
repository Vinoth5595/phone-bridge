package com.phonebridge.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phonebridge.usermanagement.model.Account;
import com.phonebridge.usermanagement.model.User;

/**
* Phone Bridge account repository 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends MongoRepository<Account, String> {
	Account findByAccountId(int accountId);
}
