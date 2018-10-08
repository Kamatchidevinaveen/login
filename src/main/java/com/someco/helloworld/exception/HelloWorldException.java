package com.someco.helloworld.exception;

import java.io.Serializable;

public class HelloWorldException extends Exception implements Serializable {
	
	private static final long serialVersionUID = -2840955466258996833L;

	public HelloWorldException(String msg) {
		super(msg);
	}

}
