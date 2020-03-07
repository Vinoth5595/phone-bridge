package com.phonebridge.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Phone Bridge user already exists exception
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {
	/**
	 * user already exists exception
	 * 
	 * @param message
	 */
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
