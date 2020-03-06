package com.phonebridge.usermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.usermanagement.dto.UserDTO;
import com.phonebridge.usermanagement.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
* Phone Bridge user controller 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService; // User service reference

	/**
	 * To create the user
	 * 
	 * @param user
	 * @return created user
	 */
	@PostMapping("/create")
	public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO user) {
		UserDTO userDto = userService.createUser(user);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}

	/**
	 * To delete the user by id
	 * 
	 * @param id
	 * @return no content status on success
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDTO> delete(@PathVariable("id") String id) {
		UserDTO userDto = userService.deleteUser(id);
		return new ResponseEntity<>(userDto, HttpStatus.NO_CONTENT);
	}

	/**
	 * To get all the users
	 * 
	 * @return list of users
	 */
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> userDtoList = userService.findAll();
		return new ResponseEntity<>(userDtoList, HttpStatus.OK);
	}

	/**
	 * To get the list of user by id
	 * 
	 * @param id
	 * @return user detail
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") String id) {
		log.info("id::" + id);
		UserDTO userDto = userService.findById(id);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	/**
	 * To update the user details by id
	 * 
	 * @param todoEntry
	 * @return no content status, on successs
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@RequestBody @Valid UserDTO todoEntry) {
		UserDTO userDto = userService.updateUser(todoEntry);
		return new ResponseEntity<>(userDto, HttpStatus.NO_CONTENT);
	}

}
