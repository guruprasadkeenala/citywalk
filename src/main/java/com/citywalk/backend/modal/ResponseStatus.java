package com.citywalk.backend.modal;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This is the bean object which is related to response
 * @author Guru
 *
 */
@JsonInclude(Include.NON_NULL)
public class ResponseStatus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String status;
	
	private String message;
	
	private String errors;
	
	private Integer responseCode;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}
	
}
