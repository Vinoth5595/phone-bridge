package com.phonebridge.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Phone Bridge invalid account exception
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAccountException extends RuntimeException {
	/**
	 * user already exists exception
	 * 
	 * @param message
	 */
	public InvalidAccountException(String message) {
		super(message);
	}
}
