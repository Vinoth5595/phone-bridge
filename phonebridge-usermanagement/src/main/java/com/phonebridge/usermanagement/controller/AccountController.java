package com.phonebridge.usermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.usermanagement.dto.AccountDTO;
import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.service.AccountService;

import lombok.extern.slf4j.Slf4j;

/**
 * Phone Bridge account controller
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService; // Account service reference

	/**
	 * To get all account details
	 * 
	 * @return accountDto list
	 */
	@GetMapping("/all")
	public ResponseEntity<List<AccountDTO>> getAllAccountDetails() {
		List<AccountDTO> accountDtoList = accountService.findAll();
		return new ResponseEntity<>(accountDtoList, HttpStatus.OK);
	}

	/**
	 * To get the account by id
	 * 
	 * @param accountId
	 * @param userId
	 * @return account detail
	 */
	@GetMapping(value = "/{accountId}")
	public ResponseEntity<AccountDTO> findByAccountId(@PathVariable("accountId") int accountId) {
		log.info("accountId:" + accountId);
		AccountDTO accountDto = accountService.findByAccountId(accountId);
		return new ResponseEntity<>(accountDto, HttpStatus.OK);
	}


	/**
	 * To create the account
	 * 
	 * @param user
	 * @return created user
	 */
	@PostMapping
	public ResponseEntity<AccountDTO> create(@RequestBody @Valid AccountDTO account) {
		AccountDTO accountDto = accountService.createAccount(account);
		return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
	}

	/**
	 * To update the user details by id
	 * 
	 * @param accountId
	 * @param userId
	 * @param todoEntry
	 * @return no content status, on success
	 */
	@PutMapping(value = "/{accountId}")
	public ResponseEntity<AccountDTO> updateAccount(@PathVariable("accountId") int accountId,
			 @RequestBody @Valid AccountDTO accountDTO) {
		AccountDTO userDto = accountService.updateAccount(accountId, accountDTO);
		return new ResponseEntity<>(userDto, HttpStatus.NO_CONTENT);
	}


	/**
	 * To delete account by account id
	 * 
	 * @param accountId
	 * @param userId
	 * @return no content status on success
	 */
	@DeleteMapping(value = "/{accountId}")
	public ResponseEntity<UserDTO> deleteUserByAccountIdAndUserId(@PathVariable("accountId") int accountId) {
		accountService.deleteAccountByAccountId(accountId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
