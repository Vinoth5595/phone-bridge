package com.phonebridge.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Phone Bridge invalid parameter exception
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends RuntimeException{
	/**
	 * invalid parameter exception
	 * 
	 * @param message
	 */
	public InvalidParameterException(String message) {
		super(message);
	}
}
