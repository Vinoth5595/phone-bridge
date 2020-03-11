package com.phonebridge.authserver.db.mongo.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.phonebridge.authserver.db.mongo.v1.row.DBRowUser;
import com.phonebridge.authserver.row.UserRow;

/**
* Phone Bridge user mapper 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

@Component
@Mapper(componentModel="spring")
public interface DBUserMapper {

	DBRowUser userRowtoDBUserRow(UserRow userRow);
	
	UserRow dbUserRowtoUserRow(DBRowUser dbUserRow);
	
	List<UserRow> dbUserRowLstToUserRowList(List<DBRowUser> dbRowUserList);

}
