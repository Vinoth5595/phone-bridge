package com.phonebridge.authserver.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
* Phone Bridge record not found exception 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException{
	
	/**
	 * record not found exception
	 * 
	 * @param message
	 */
	public RecordNotFoundException(String message){
		super(message);
	}
}
