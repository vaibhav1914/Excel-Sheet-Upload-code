package com.jbk.exceptions;

public class CustomExceptionResponse {

	private String path;
	private String message;
	private String timeStamp;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomExceptionResponse(String path, String message, String timeStamp) {
		super();
		this.path = path;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
}
