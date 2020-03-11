package com.phonebridge.authserver.db.mongo.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.phonebridge.authserver.db.mongo.v1.row.DBRowAccount;
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
public interface DBAccountMapper {
	
	DBRowAccount accountRowToAccountDBRow(AccountRow accountRow);

	AccountRow dbRowAccountToAccountRow(DBRowAccount dbRowDccount);

	List<DBRowAccount> AccountRowListToDBRowAccountList(List<AccountRow> accountRowLst);

	List<AccountRow> dbRowAccountLstToAccountRowLst(List<DBRowAccount> dbAccountRowLst);
}
