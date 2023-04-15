package com.davi.shop.dto.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private Map<String, String> errors;

    private ErrorDetails(final Date timestamp, final String message,
	    final String details, final Map<String, String> errors) {
	this.timestamp = timestamp;
	this.message = message;
	this.details = details;
	this.errors = errors;
    }

    public ErrorDetails(final Date timestamp, final String message,
	    final String details) {
	this.timestamp = timestamp;
	this.message = message;
	this.details = details;
	this.errors = new HashMap<>();
    }

    public static ErrorDetails with(final String message,
	    final String details, final Map<String, String> errors) {
	return new ErrorDetails(new Date(), message, details, errors);
    }

    public static ErrorDetails with(final String message,
	    final String details) {
	return new ErrorDetails(new Date(), message, details,
		new HashMap<>());
    }

    public Date getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public Map<String, String> getErrors() {
	return errors;
    }

    public void setErrors(Map<String, String> errors) {
	this.errors = errors;
    }

}