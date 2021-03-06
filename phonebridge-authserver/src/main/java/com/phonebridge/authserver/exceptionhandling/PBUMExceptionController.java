package com.phonebridge.authserver.exceptionhandling;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.phonebridge.authserver.exception.AccountDependentException;
import com.phonebridge.authserver.exception.InvalidAccountException;
import com.phonebridge.authserver.exception.InvalidParameterException;
import com.phonebridge.authserver.exception.RecordNotFoundException;
import com.phonebridge.authserver.exception.UserAlreadyExistsException;
import com.phonebridge.authserver.exception.WrongAccountException;
import com.phonebridge.authserver.rest.controller.v1.resp.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Phone Bridge user management exception controller
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@Slf4j
@ControllerAdvice
public class PBUMExceptionController {

	/**
	 * handle invalid format exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(InvalidFormatException.class)
	public final ResponseEntity<Object> invalidFormatExceptions(InvalidFormatException ex) {
		log.error("invalidFormatExceptions:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Bad Request Invalid", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * handle json mapping exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(JsonMappingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Object> jsonExceptions(JsonMappingException ex) {
		log.error("jsonExceptions:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Bad Request JSON", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * handle invalid parameter exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(InvalidParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Object> handleInvalidParameterException(InvalidParameterException ex) {
		log.error("handleInvalidParameterException:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Invalid parameter", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * handle user not found exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex) {
		log.error("handleUserNotFoundException:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Record Not Found", details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * handle user not found exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(UserAlreadyExistsException.class)
	public final ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
		log.error("handleUserAlreadyExistsException:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("User id is not available", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * handle invalid account exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(InvalidAccountException.class)
	public final ResponseEntity<Object> handleInvalidAccountException(InvalidAccountException ex) {
		log.error("handleInvalidAccountException:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Invalid Account", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * handle account dependent exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(AccountDependentException.class)
	public final ResponseEntity<Object> handleAccountDependentException(AccountDependentException ex) {
		log.error("handleAccountDependentException:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Account is linked with an user", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * handle wrong account exceptions
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(WrongAccountException.class)
	public final ResponseEntity<Object> handleWrongAccountException(WrongAccountException ex) {
		log.error("handleWrongAccountException:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Account id should not be different", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * handle all the remaining exceptions, if it is not handled by the above
	 * exception handlers
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
		log.error("handleAllExceptions:::", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Internal Server Error", details);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
