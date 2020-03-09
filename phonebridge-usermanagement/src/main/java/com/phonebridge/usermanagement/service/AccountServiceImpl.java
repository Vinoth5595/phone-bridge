package com.phonebridge.usermanagement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebridge.usermanagement.dto.AccountDTO;
import com.phonebridge.usermanagement.exception.AccountDependentException;
import com.phonebridge.usermanagement.exception.InvalidAccountException;
import com.phonebridge.usermanagement.exception.InvalidParameterException;
import com.phonebridge.usermanagement.exception.RecordNotFoundException;
import com.phonebridge.usermanagement.exception.WrongAccountException;
import com.phonebridge.usermanagement.mapper.AccountMapper;
import com.phonebridge.usermanagement.model.Account;
import com.phonebridge.usermanagement.model.User;
import com.phonebridge.usermanagement.repository.AccountRepository;
import com.phonebridge.usermanagement.repository.UserRepository;
import com.phonebridge.usermanagement.utils.CommonUtils;

@Service
public class AccountServiceImpl implements AccountService {
	private static final String NO_RECORDS_FOUND = "Record Not Found";

	@Autowired
	private UserRepository userRepository; // User repository reference

	@Autowired
	AccountRepository accountRepository; // Account repository reference

	@Autowired
	private AccountMapper accountMapper; // Account mapper

	/**
	 * To get the list of accounts.
	 */
	@Override
	public List<AccountDTO> findAll() {
		List<Account> accountList = accountRepository.findAll();
		return accountMapper.accountListToAccountDTOList(accountList);
	}

	/**
	 * To get account details by account id
	 * 
	 * @param accountId
	 * @return
	 */
	@Override
	public AccountDTO findByAccountId(ObjectId accountId) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		Account account = accountRepository.findByAccountId(accountId);
		if (account == null) {
			throw new InvalidAccountException("Invalid Account id");
		}

		return accountMapper.accountToAccountDTO(account);
	}

	/**
	 * To create account
	 * 
	 * @param accountDto
	 * @return
	 */
	@Override
	public AccountDTO createAccount(AccountDTO accountDto) {
		if (CommonUtils.isBlankOrNull(accountDto)) {
			throw new InvalidParameterException("invalid accountDto : " + accountDto);
		}
		
		Account account = accountMapper.AccountDTOToAccount(accountDto);
		account.setCreatedOn(LocalDateTime.now());
		account.setModifiedOn(LocalDateTime.now());
		Account accountPersisted = accountRepository.save(account);
		return accountMapper.accountToAccountDTO(accountPersisted);
	}

	/**
	 * To update the account
	 * 
	 * @param accountId
	 * @param accountDto
	 * @return AccountDTO
	 */
	@Override
	public AccountDTO updateAccount(ObjectId accountId, AccountDTO accountDto) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}
		
		if (CommonUtils.isBlankOrNull(accountDto)) {
			throw new InvalidParameterException("invalid accountDto : " + accountDto);
		}
		
		Optional<Account> accountFetched = accountRepository.findById(accountId);
		if (!accountFetched.isPresent()) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		if (accountId !=null && !accountId.equals(accountFetched.get().getAccountId())) {
			throw new WrongAccountException("Account id should not be different");
		}

		Account accountPassed = accountMapper.AccountDTOToAccount(accountDto);
		accountPassed.setAccountId(accountFetched.get().getAccountId());
		accountPassed.setCreatedOn(accountFetched.get().getCreatedOn());
		accountPassed.setCreatedBy(accountFetched.get().getCreatedBy());
		accountPassed.setModifiedOn(LocalDateTime.now());
		accountRepository.save(accountPassed);
		return accountMapper.accountToAccountDTO(accountPassed);
	}

	/**
	 * To delete account by account id
	 * 
	 * @param accountId
	 */
	@Override
	public void deleteAccountByAccountId(ObjectId accountId) {
		if (CommonUtils.isBlankOrNull(accountId)) {
			throw new InvalidParameterException("invalid accountId : " + accountId);
		}

		Optional<Account> accountReturned = accountRepository.findById(accountId);
		if (!accountReturned.isPresent()) {
			throw new RecordNotFoundException(NO_RECORDS_FOUND);
		}

		List<User> userList = userRepository.findByAccountId(accountId);

		if (userList != null && userList.size() > 0) {
			throw new AccountDependentException("Account is linked with an user");
		}

		accountRepository.delete(accountReturned.get());
	}
}
