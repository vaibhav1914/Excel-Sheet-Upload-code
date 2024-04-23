package com.jbk.exceptions;

import java.util.Map;

public class ExcelSheelDataNotValid extends RuntimeException{

	private Map<String, String> errorMap;
	public ExcelSheelDataNotValid(Map<String,String >errorMap)
	{
		super("Invalid excel Data");
		  this.errorMap = errorMap;
	}
	 public Map<String, String> getErrorMap() {
	        return errorMap;
	    }
}
