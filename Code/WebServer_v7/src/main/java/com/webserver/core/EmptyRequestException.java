package com.webserver.core;
/**
 * 	�������쳣
 * @author Grant��Vranes
 *
 */
public class EmptyRequestException extends Exception{
	private static final long serialVersionUID = 1L;

	//����Ҽ�ѡ��source��ѡ�����ڶ���Generate Constructors from SuperClass
	public EmptyRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
