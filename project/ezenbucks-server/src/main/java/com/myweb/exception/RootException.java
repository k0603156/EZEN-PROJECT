package com.myweb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * Exception 커스텀 처리를 위해 상속받아 처리
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RootException extends RuntimeException{
	private int exceptionCode;
	private String message;
}
