package com.myweb.exception;

import lombok.Getter;
/** 
 * Exception Error 컨트롤러
 * 에러 핸들링 위한 클래스
 */
@Getter
public enum ErrorCode {
	MethodNotAllowed (405, "MethodNotAllow"),
	InternalServerError (500, "Server Error"),
	AccessDenied (403, "Access is Denied"),
	BadResquest (400, "Bad Request"),
	NotFound (404, "Not Found"),
	
	DBSelectError (1001, "DB Qurey Select Error"),
	MapRequestError (1002, "Map Request RestTemplate Error");
	
	private int errorCode;
	private String message;
	
	private ErrorCode(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
}
