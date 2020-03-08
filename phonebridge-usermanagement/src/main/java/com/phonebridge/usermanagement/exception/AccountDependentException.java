package com.phonebridge.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Phone Bridge account dependent exception
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountDependentException extends RuntimeException {
	/**
	 * account dependent exception
	 * 
	 * @param message
	 */
	public AccountDependentException(String message) {
		super(message);
	}
}
