package com.phonebridge.authserver.rest.controller.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.phonebridge.authserver.rest.controller.v1.req.NewAccountReq;
import com.phonebridge.authserver.rest.controller.v1.req.UpdateAccountReq;
import com.phonebridge.authserver.rest.controller.v1.resp.AccountResp;
import com.phonebridge.authserver.row.AccountRow;

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
	AccountResp accountRowToAccountResp(AccountRow account);

	/**
	 * to map from AccountDTO to Account
	 * 
	 * @param AccountResp
	 * @return Account
	 */
	AccountRow newAccountReqToAccountRow(NewAccountReq newAccountReq);

	AccountRow updateAccountReqToAccountRow(UpdateAccountReq updateAccountReq);
	
	/**
	 * to map from user list to AccountDTO list
	 * 
	 * @param accountList
	 * @return accountDto list
	 */
	List<AccountResp> accountRowListToAccountRespList(List<AccountRow> accountList);
}
