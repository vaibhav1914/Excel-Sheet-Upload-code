package com.jbk.exceptions;

public class ResourcesAlreadyExist  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	public ResourcesAlreadyExist(String msg) 
	{
		super(msg);
	}
}
