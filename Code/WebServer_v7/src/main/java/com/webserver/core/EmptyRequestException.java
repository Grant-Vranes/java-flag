package com.webserver.core;
/**
 * 	空请求异常
 * @author Grant·Vranes
 *
 */
public class EmptyRequestException extends Exception{
	private static final long serialVersionUID = 1L;

	//鼠标右键选择source，选择倒数第二个Generate Constructors from SuperClass
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
