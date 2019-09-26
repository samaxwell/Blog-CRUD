package com.blog.crud.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
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
	protected ResponseEntity<Object> handleMethodArgumentNotValidException(
													MethodArgumentNotValidException e, 
													WebRequest webRequest) {

		List<String> messages = e.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.toList());
		
		return new ResponseEntity<Object>(
				new ErrorMessage(messages, webRequest.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnsatisfiedConstraint.class)
	protected ResponseEntity<Object> handleUnsatisfiedConstraintException(
													UnsatisfiedConstraint e,
													WebRequest webRequest) {
		List<String> messages = new ArrayList<String>();
		messages.add(e.getMessage());

		return new ResponseEntity<Object>(
				new ErrorMessage(messages, webRequest.getDescription(false)),
				HttpStatus.CONFLICT);
	}

}
