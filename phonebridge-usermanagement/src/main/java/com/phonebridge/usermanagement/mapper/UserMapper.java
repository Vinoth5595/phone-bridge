package com.phonebridge.usermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.model.User;

@Component
@Mapper(componentModel="spring")
public interface UserMapper {
	
	UserDTO userToUserDTO(User user);

	User UserDTOtoUser(UserDTO userDto);
	
	List<User> userDtoListToUserList(List<UserDTO> userDtoList);
	
	List<UserDTO> userListToUserDtoList(List<User> userList);

}
