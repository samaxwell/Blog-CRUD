package com.blog.crud.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionController {
	
	/*
	 * Map Java Bean constraint violations to something 
	 * readable
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
													MethodArgumentNotValidException e, 
													WebRequest webRequest) {

		List<String> messages = e.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.toList());
		
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(messages, webRequest.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnsatisfiedConstraint.class)
	protected ResponseEntity<ErrorMessage> handleUnsatisfiedConstraintException(
													UnsatisfiedConstraint e,
													WebRequest webRequest) {

		return new ResponseEntity<ErrorMessage>(extractMessage(e, webRequest), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<ErrorMessage> handleResourceNotFoundException(
													ResourceNotFoundException e,
													WebRequest webRequest) {
		
		return new ResponseEntity<ErrorMessage>(extractMessage(e, webRequest), HttpStatus.NOT_FOUND);
	}
	
	
	
	/*
	 * Helper method to extract messages from exceptions
	 * and wrap them in a generic 'errorMessage' object
	 */
	private ErrorMessage extractMessage(RuntimeException e, WebRequest webRequest) {
		List<String> messages = new ArrayList<String>();
		messages.add(e.getMessage());

		return new ErrorMessage(messages, webRequest.getDescription(false));
	}

}
