package com.phonebridge.authserver.rest.controller.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.authserver.rest.controller.v1.mapper.AccountMapper;
import com.phonebridge.authserver.rest.controller.v1.req.NewAccountReq;
import com.phonebridge.authserver.rest.controller.v1.req.UpdateAccountReq;
import com.phonebridge.authserver.rest.controller.v1.resp.AccountResp;
import com.phonebridge.authserver.row.AccountRow;
import com.phonebridge.authserver.service.IAccountService;

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
@RequestMapping("/v1/account")
public class AccountController {

	@Autowired
	private IAccountService accountService; // Account service reference

	@Autowired
	private AccountMapper accountMapper;
	/**
	 * To get all account details
	 * 
	 * @return accountDto list
	 */
	@GetMapping("/all")
	public ResponseEntity<List<AccountResp>> getAllAccountDetails() {
		List<AccountRow> accountRowList = accountService.findAll();
		List<AccountResp> accountRowListToAccountRespList = accountMapper.accountRowListToAccountRespList(accountRowList);
		return new ResponseEntity<>(accountMapper.accountRowListToAccountRespList(accountRowList)
										, HttpStatus.OK);
	}

	/**
	 * To get the account by id
	 * 
	 * @param accountId
	 * @param userId
	 * @return account detail
	 */
	@GetMapping(value = "/{accountId}")
	public ResponseEntity<AccountResp> findByAccountId(@PathVariable("accountId") String accountId) {
		log.info("accountId:" + accountId);
		AccountRow accountRow = accountService.findById(accountId);
		return new ResponseEntity<>(accountMapper.accountRowToAccountResp(accountRow)
										, HttpStatus.OK);
	}


	/**
	 * To create the account
	 * 
	 * @param user
	 * @return created user
	 */
	@PostMapping
	public ResponseEntity<AccountResp> create(@RequestBody @Valid NewAccountReq newAccountReq) {
		AccountRow givenAccountRow = accountMapper.newAccountReqToAccountRow(newAccountReq);
		AccountRow accountRow = accountService.createAccount(givenAccountRow);
		return new ResponseEntity<>(accountMapper.accountRowToAccountResp(accountRow)
											, HttpStatus.CREATED);
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
	public ResponseEntity<AccountResp> updateAccount(@RequestBody @Valid UpdateAccountReq updateAccountReq) {
		AccountRow givenAccountRow = accountMapper.updateAccountReqToAccountRow(updateAccountReq);
		AccountRow updatedAccountRow = accountService.updateAccount(givenAccountRow);
		return new ResponseEntity<>(accountMapper.accountRowToAccountResp(updatedAccountRow)
										,HttpStatus.NO_CONTENT);
	}


}
