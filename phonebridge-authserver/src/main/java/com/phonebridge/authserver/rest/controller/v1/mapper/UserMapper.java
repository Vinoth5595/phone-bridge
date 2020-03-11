package com.phonebridge.authserver.rest.controller.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.phonebridge.authserver.rest.controller.v1.req.NewUserReq;
import com.phonebridge.authserver.rest.controller.v1.req.UpdateUserReq;
import com.phonebridge.authserver.rest.controller.v1.resp.UserResp;
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
public interface UserMapper {

	/**
	 * to map from userDto to User
	 * 
	 * @param userDto
	 * @return User
	 */
	UserRow userReqtoUserRow(NewUserReq newUserReq);
	
	UserResp userRowtoUserResp(UserRow userRow);
	
	UserRow updateUserReqtoUserRow(UpdateUserReq updateUserReq);
	
	/**
	 * to map from user list to userDto list
	 * 
	 * @param userList
	 * @return userDTO list
	 */
	List<UserResp> userRowListToUserRespList(List<UserRow> userList);

}
