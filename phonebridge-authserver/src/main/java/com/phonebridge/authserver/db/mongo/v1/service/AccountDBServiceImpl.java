package com.phonebridge.authserver.db.mongo.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebridge.authserver.db.mongo.v1.mapper.DBAccountMapper;
import com.phonebridge.authserver.db.mongo.v1.repository.AccountRepository;
import com.phonebridge.authserver.db.mongo.v1.row.DBRowAccount;
import com.phonebridge.authserver.exception.InvalidAccountException;
import com.phonebridge.authserver.exception.InvalidParameterException;
import com.phonebridge.authserver.exception.RecordNotFoundException;
import com.phonebridge.authserver.row.AccountRow;
import com.phonebridge.authserver.service.IAccountService;
import com.phonebridge.authserver.utils.CommonUtils;

@Service
public class AccountDBServiceImpl implements IAccountService {
	private static final String NO_RECORDS_FOUND = "Record Not Found";

	@Autowired
	AccountRepository accountRepository; // Account repository reference

	@Autowired
	private DBAccountMapper dbAccountMapper; // Account mapper

	/**
	 * To get the list of accounts.
	 */
	@Override
	public List<AccountRow> findAll() {
		List<DBRowAccount> accountList = accountRepository.findAll();
		return dbAccountMapper.dbRowAccountLstToAccountRowLst(accountList);
	}

	/**
	 * To get account details by account id
	 * 
	 * @param accountId
	 * @return
	 */
	@Override
	public AccountRow findById(String accountId) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		Optional<DBRowAccount> account = accountRepository.findById(accountId);
		if (!account.isPresent()) {
			throw new InvalidAccountException("Invalid Account id");
		}
		return dbAccountMapper.dbRowAccountToAccountRow(account.get());
	}

	/**
	 * To create account
	 * 
	 * @param accountRow
	 * @return
	 */
	@Override
	public AccountRow createAccount(AccountRow accountRow) {
		if (CommonUtils.isBlankOrNull(accountRow)) {
			throw new InvalidParameterException("invalid accountDto : " + accountRow);
		}
		
		DBRowAccount dbAccount = dbAccountMapper.accountRowToAccountDBRow(accountRow);
		DBRowAccount accountPersisted = accountRepository.save(dbAccount);
		return dbAccountMapper.dbRowAccountToAccountRow(accountPersisted);
	}

	/**
	 * To update the account
	 * 
	 * @param accountId
	 * @param accountRow
	 * @return AccountDTO
	 */
	@Override
	public AccountRow updateAccount(AccountRow accountRow) {
		
		if (CommonUtils.isBlankOrNull(accountRow)) {
			throw new InvalidParameterException("invalid accountDto : " + accountRow);
		}
		if (CommonUtils.isBlankOrNull(accountRow.getId())) {
			throw new InvalidParameterException("invalid accountId : " + accountRow.getId());
		}
		
		DBRowAccount accountPassed = dbAccountMapper.accountRowToAccountDBRow(accountRow);
		DBRowAccount result = accountRepository.save(accountPassed);
		if (null==result) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}
		return dbAccountMapper.dbRowAccountToAccountRow(result);
	}

	@Override
	public void deleteAccountByAccountId(String accountId) {
		// TODO Auto-generated method stub
	}

}
