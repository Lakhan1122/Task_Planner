package com.lakhan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskException extends RuntimeException{

	public TaskException(String message) {
		super(message);
	}
}
