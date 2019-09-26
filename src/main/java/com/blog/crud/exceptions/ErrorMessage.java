package com.blog.crud.exceptions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Getter;

@Getter
public class ErrorMessage {

	private String resource;
	private String timestamp;
	private List<String> errorMessages;
	
	public ErrorMessage(List<String> errorMessages, String resource) {
		this.errorMessages = errorMessages;
		this.resource = resource;
		this.timestamp = LocalDateTime.now(ZoneId.of("America/New_York"))
				.format(DateTimeFormatter.ofPattern("HH:mm:ss - MMM dd, yyyy"));
	}
}
