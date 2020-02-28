package com.phonebridge.portalservice.exception;

import java.util.List;

public class ErrorResponse {

	private String errorMessage;
	private List<String> details;
	
	public ErrorResponse(String errorMessage, List<String> details) {
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public List<String> getDetails() {
		return details;
	}

}
