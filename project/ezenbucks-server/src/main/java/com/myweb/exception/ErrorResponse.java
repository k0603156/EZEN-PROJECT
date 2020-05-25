package com.myweb.exception;

import java.lang.ref.WeakReference;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
/** 
 * Error 반환을 위한 클래스
 */
@Getter
public class ErrorResponse {
	private int errordCode;
	private String message;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime createAt;
	
	public static ErrorResponse create(int errorCode, String message) {
		ErrorResponse res = new ErrorResponse(errorCode, message);
		return res;
	}
	
	public static ErrorResponse create(ErrorCode errorCode) {
		ErrorResponse res = new ErrorResponse(errorCode.getErrorCode(), errorCode.getMessage());
		return new WeakReference<>(res).get();
	}
	
	private ErrorResponse(int errorCode, String message) {
		this.errordCode = errorCode;
		this.message = message;
		this.createAt = LocalDateTime.now();
	}
}
