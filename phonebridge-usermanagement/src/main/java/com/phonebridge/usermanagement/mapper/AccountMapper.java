package com.phonebridge.usermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.phonebridge.usermanagement.dto.AccountDTO;
import com.phonebridge.usermanagement.model.Account;

/**
 * Phone Bridge account mapper
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@Component
@Mapper(componentModel = "spring")
public interface AccountMapper {
	
	/**
	 * to map from account to AccountDTO
	 * 
	 * @param account
	 * @return AccountDTO
	 */
	AccountDTO accountToAccountDTO(Account account);

	/**
	 * to map from AccountDTO to Account
	 * 
	 * @param AccountDTO
	 * @return Account
	 */
	Account AccountDTOToAccount(AccountDTO accountDTO);

	/**
	 * to map from AccountDTO list to user list
	 * 
	 * @param AccountDTOList
	 * @return Account List
	 */
	List<Account> AccountDTOListToAccountList(List<AccountDTO> AccountDTOList);

	/**
	 * to map from user list to AccountDTO list
	 * 
	 * @param accountList
	 * @return accountDto list
	 */
	List<AccountDTO> accountListToAccountDTOList(List<Account> accountList);
}
