package com.phonebridge.usermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody @Valid UserDTO user) {
        return userService.createUser(user);
    }
	
	@DeleteMapping(value = "/{id}")
	public UserDTO delete(@PathVariable("id") String id) {
        return userService.deleteUser(id);
    }

	@GetMapping("/all")
	public List<UserDTO>  findAll() {
        return userService.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public UserDTO findById(@PathVariable("id") String id) {
		log.info("id::"+id);
        return userService.findById(id);
    }
	
	@PutMapping(value = "/{id}")
	public UserDTO update(@RequestBody @Valid UserDTO todoEntry) {
        return userService.updateUser(todoEntry);
    }
	
}
