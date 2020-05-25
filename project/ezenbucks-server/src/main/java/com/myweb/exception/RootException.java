package com.myweb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * Exception Ŀ���� ó���� ���� ��ӹ޾� ó��
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RootException extends RuntimeException{
	private int exceptionCode;
	private String message;
}
