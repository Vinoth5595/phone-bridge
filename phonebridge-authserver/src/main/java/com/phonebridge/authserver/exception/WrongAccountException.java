package com.phonebridge.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Phone Bridge wrong account exception
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongAccountException extends RuntimeException {
	/**
	 * user wrong account exception
	 * 
	 * @param message
	 */
	public WrongAccountException(String message) {
		super(message);
	}
}
