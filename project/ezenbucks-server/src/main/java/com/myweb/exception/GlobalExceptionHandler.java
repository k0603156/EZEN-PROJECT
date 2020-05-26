package com.myweb.exception;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;
/** 
 * Error �ڵ鷯
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(RootException.class)
	protected ResponseEntity<ErrorResponse> rootException(RootException e) {
		log.error("RootException Exception : ", e);
		final ErrorResponse errorResopnse = ErrorResponse.create(e.getExceptionCode(), e.getMessage());
		return new ResponseEntity<>(errorResopnse, HttpStatus.valueOf(errorResopnse.getErrordCode()));
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) { 
		log.error("HttpRequestMethodNotSupported Exception", e);
		return new ResponseEntity<>(ErrorResponse.create(ErrorCode.MethodNotAllowed), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<ErrorResponse> accessDeniedExeption(AccessDeniedException e) { 
		log.error("AccessDenied Exception : ", e);
		return new ResponseEntity<>(ErrorResponse.create(ErrorCode.AccessDenied), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) { 
		log.error("MethodArgumentTypeMismatch Exception : ", e);
		return new ResponseEntity<>(ErrorResponse.create(ErrorCode.BadResquest), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> basicException(Exception e) { 
		log.error("Basic Exception : ", e);
		return new ResponseEntity<>(ErrorResponse.create(ErrorCode.InternalServerError), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<ErrorResponse> notFoundException(NoHandlerFoundException e) {
		log.error("Not Found Exception : ", e);
		return new ResponseEntity<>(ErrorResponse.create(ErrorCode.NotFound), HttpStatus.NOT_FOUND);
	}
}
