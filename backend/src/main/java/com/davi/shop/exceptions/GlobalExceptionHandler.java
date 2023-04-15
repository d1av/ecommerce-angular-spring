package com.davi.shop.exceptions;

import java.nio.file.AccessDeniedException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.davi.shop.dto.exceptions.ErrorDetails;
import com.davi.shop.dto.exceptions.StandardError;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
@EnableWebSecurity
public class GlobalExceptionHandler
	extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(
	    DataNotFoundException e, HttpServletRequest request) {
	HttpStatus status = HttpStatus.BAD_REQUEST;
	StandardError err = new StandardError();
	err.setTimestamp(Instant.now());
	err.setStatus(status.value());
	err.setError("Incorrect search parameter.");
	err.setMessage(e.getMessage());
	err.setPath(request.getRequestURI());
	return ResponseEntity.status(status).body(err);
    }

    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
	    ResourceNotFoundException exception,
	    WebRequest webRequest) {
	ErrorDetails errorDetails = new ErrorDetails(new Date(),
		exception.getMessage(),
		webRequest.getDescription(false));
	return new ResponseEntity<>(errorDetails,
		HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShopAPIException.class)
    public ResponseEntity<ErrorDetails> handleBlogAPIException(
	    ShopAPIException exception, WebRequest webRequest) {
	ErrorDetails errorDetails = new ErrorDetails(new Date(),
		exception.getMessage(),
		webRequest.getDescription(false));
	return new ResponseEntity<>(errorDetails,
		HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ AuthenticationException.class })
    @ResponseBody
    public ResponseEntity<ErrorDetails> handleAuthenticationException(
	    Exception ex, WebRequest webRequest) {

	ErrorDetails errorDetails = new ErrorDetails(new Date(),
		ex.getMessage(), webRequest.getDescription(false));
	return new ResponseEntity<>(errorDetails,
		HttpStatus.BAD_REQUEST);
    }

    // global exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
//                                                              WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
//                webRequest.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//	    MethodArgumentNotValidException ex, HttpHeaders headers,
//	    HttpStatusCode status, WebRequest request) {
//	Map<String, String> errors = new HashMap<>();
//	ex.getBindingResult().getAllErrors().forEach((error) -> {
//	    String fieldName = ((FieldError) error).getField();
//	    String message = error.getDefaultMessage();
//	    errors.put(fieldName, message);
//	});
//
//	return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
//                                                                        WebRequest webRequest){
//        Map<String, String> errors = new HashMap<>();
//        exception.getBindingResult().getAllErrors().forEach((error) ->{
//            String fieldName = ((FieldError)error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(
	    AccessDeniedException exception, WebRequest webRequest) {
	ErrorDetails errorDetails = new ErrorDetails(new Date(),
		exception.getMessage(),
		webRequest.getDescription(false));
	return new ResponseEntity<>(errorDetails,
		HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(
	    PropertyReferenceException exception,
	    WebRequest webRequest) {
	ErrorDetails errorDetails = new ErrorDetails(new Date(),
		exception.getMessage(),
		webRequest.getDescription(false));
	return new ResponseEntity<>(errorDetails,
		HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationExceptions(
	    ConstraintViolationException ex, WebRequest request) {
	Map<String, String> errors = new HashMap<>();
	ex.getConstraintViolations().forEach((error) -> {
	    String fieldName = error.getPropertyPath().toString();
	    String errorMessage = error.getMessage();
	    errors.put(fieldName, errorMessage);

	});
	ErrorDetails errorDetails = ErrorDetails.with(ex.getMessage(),
		request.getDescription(false), errors);
	return new ResponseEntity<>(errorDetails,
		HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatusCode status, WebRequest request) {
	Map<String, String> errors = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error) -> {
	    String fieldName = ((FieldError) error).getField();
	    String errorMessage = error.getDefaultMessage();
	    errors.put(fieldName, errorMessage);
	});
	ErrorDetails errorDetails = ErrorDetails.with(
		ex.getMessage().substring(0, 100),
		request.getDescription(false), errors);

	return new ResponseEntity<>(errorDetails,
		HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
