package com.devsuperior.dslearnbds.services.exceptions;

public class NestedResourceNotFoundException extends RuntimeException{

 
	private static final long serialVersionUID = 1L;

	public NestedResourceNotFoundException(String msg) {
		super(msg);
	}

}
