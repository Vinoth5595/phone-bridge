package com.phonebridge.usermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.model.User;

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
	 * to map from user to userDTo
	 * 
	 * @param user
	 * @return UserDTO
	 */
	UserDTO userToUserDTO(User user);

	/**
	 * to map from userDto to User
	 * 
	 * @param userDto
	 * @return User
	 */
	User UserDTOtoUser(UserDTO userDto);
	
	/**
	 * to map from userDto list to user list
	 * 
	 * @param userDtoList
	 * @return user list 
	 */
	List<User> userDtoListToUserList(List<UserDTO> userDtoList);
	
	/**
	 * to map from user list to userDto list
	 * 
	 * @param userList
	 * @return userDTO list
	 */
	List<UserDTO> userListToUserDtoList(List<User> userList);

}
