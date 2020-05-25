package com.myweb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RootException extends RuntimeException{
	private int exceptionCode;
	private String message;
}
