package com.std.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
	private Boolean ststus;
	private String msg;
	private Integer statusCode;
	@JsonInclude(Include. NON_NULL)
	private Object data;
}
