package com.phonebridge.usermanagement.service;

import java.util.List;

import com.phonebridge.usermanagement.dto.AccountDTO;

public interface AccountService {

	
	/**
	 * To get the list of accounts.
	 * 
	 * @return AccountDTO list
	 */
	List<AccountDTO> findAll();
	
	/**
	 * To get account details by account id
	 * 
	 * @param accountId
	 * @return AccountDTO
	 */
	AccountDTO findByAccountId(int accountId);
	
	/**
	 * To create account
	 * 
	 * @param accountDto
	 * @return AccountDTO
	 */
	AccountDTO createAccount(AccountDTO accountDto);
	
	/**
	 * To update the account
	 * 
	 * @param accountId
	 * @param accountDto
	 * @return AccountDTO
	 */
	AccountDTO updateAccount(int accountId, AccountDTO accountDto);

	/**
	 * To delete account by account id
	 * 	
	 * @param accountId
	 */
	void deleteAccountByAccountId(int accountId);
}
