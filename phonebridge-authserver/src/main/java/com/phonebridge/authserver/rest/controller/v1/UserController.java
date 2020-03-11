package com.phonebridge.authserver.rest.controller.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.authserver.rest.controller.v1.mapper.UserMapper;
import com.phonebridge.authserver.rest.controller.v1.req.NewUserReq;
import com.phonebridge.authserver.rest.controller.v1.req.UpdateUserReq;
import com.phonebridge.authserver.rest.controller.v1.resp.UserResp;
import com.phonebridge.authserver.row.UserRow;
import com.phonebridge.authserver.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Phone Bridge user controller
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private IUserService userService; // User service reference

	/**
	 * To create the user
	 * 
	 * @param newUserRq
	 * @return created user
	 */
	@PostMapping
	public ResponseEntity<String> create(@RequestBody @Valid NewUserReq newUserRq) {
		UserRow userRow = userMapper.userReqtoUserRow(newUserRq);
		userRow = userService.createUser(userRow);
		return new ResponseEntity<>(userRow.getId(), HttpStatus.CREATED);
	}

	/**
	 * To get all the users
	 * 
	 * @return list of users
	 */
	@GetMapping("/all")
	public ResponseEntity<List<UserResp>> findAll() {
		List<UserRow> userRowLst = userService.findAll();
		List<UserResp> result= userMapper.userRowListToUserRespList(userRowLst);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * To get all the users in an account
	 * 
	 * @param accountId
	 * @return list of users
	 */
	@GetMapping("/{accountId}/all")
	public ResponseEntity<List<UserResp>> findAllByAccountId(@PathVariable("accountId") String accountId) {
		List<UserRow> userRowLst = userService.findAllByAccountId(accountId);
		List<UserResp> result= userMapper.userRowListToUserRespList(userRowLst);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * To update the user details by id
	 * 
	 * @param accountId
	 * @param userId
	 * @param todoEntry
	 * @return no content status, on success
	 */
	@PutMapping
	public ResponseEntity<UserResp> updateUser(@RequestBody @Valid UpdateUserReq updateUserReq) {
		UserRow givenUserRow=userMapper.updateUserReqtoUserRow(updateUserReq);
		UserRow userRow = userService.updateUser(givenUserRow);
		UserResp result=userMapper.userRowtoUserResp(userRow);
		return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
	}

}
