package com.std.handller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.std.common.Response;

@RestControllerAdvice
public class ExHandller {
	
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ResponseEntity<Response> resourceNotFound(Exception e){
		Response resp = Response.builder()
				.ststus(false)
				.msg(e.getMessage())
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.build();
		return new ResponseEntity<Response>(resp, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Response> internalError(Exception e){
		Response resp = Response.builder()
				.ststus(false)
				.msg(e.getLocalizedMessage())
				.statusCode(HttpStatus.CREATED.value())
				.build();
		return new ResponseEntity<Response>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
