package com.jbk.exceptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArugumentInvalid(MethodArgumentNotValidException methodArgumentNotValidException)
	{
		Map<String, String>errorMap=new HashMap<String, String>();
		List<FieldError>eFieldErrors=methodArgumentNotValidException.getFieldErrors();
		for (FieldError fieldError : eFieldErrors) {
			String filedName=fieldError.getField();
			String filedMessage=fieldError.getDefaultMessage();
			errorMap.put(filedName, filedMessage);
		}
		return errorMap;
	}
	
	@ExceptionHandler(ResourcesAlreadyExist.class)
	public CustomExceptionResponse resourcesAlreadyExist(ResourcesAlreadyExist aResourcesAlreadyExist,HttpServletRequest request) 
	{
		String path=request.getRequestURI();
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        String msg=aResourcesAlreadyExist.getMessage();
        CustomExceptionResponse response=new CustomExceptionResponse(path,msg,timeStamp);
		return response;
	}
	
	@ExceptionHandler(SomethingWentWrong.class)
	public CustomExceptionResponse somethingWentWrong(SomethingWentWrong somethingWentWrong,HttpServletRequest request) 
	{
		String path=request.getRequestURI();
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        String msg=somethingWentWrong.getMessage();
        CustomExceptionResponse response=new CustomExceptionResponse(path,msg,timeStamp);
		return response;
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public CustomExceptionResponse resourceNotFound (ResourceNotFound rNotFound,HttpServletRequest request) 
	{
		String path=request.getRequestURI();
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        String msg=rNotFound.getMessage();
        CustomExceptionResponse response=new CustomExceptionResponse(path,msg,timeStamp);
		return response;
	
	}
	@ExceptionHandler(ExcelSheelDataNotValid.class)
	public ResponseEntity<Map<String, String>> handleExcelSheelDataNotValid(ExcelSheelDataNotValid exception) {
        Map<String, String> errorMap = exception.getErrorMap();
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
	
}
