package com.phonebridge.authserver.rest.controller.v1.resp;

import java.util.List;

/**
* Phone Bridge error response 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

public class ErrorResponse {

	private String errorMessage; // error message
	private List<String> details; // details of error message
	
	/**
	 * To create error response using constructor
	 * 
	 * @param errorMessage
	 * @param details
	 */
	public ErrorResponse(String errorMessage, List<String> details) {
		this.errorMessage = errorMessage;
		this.details = details;
	}

	/**
	 * To get error message
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * To get error details
	 * 
	 * @return
	 */
	public List<String> getDetails() {
		return details;
	}

}
