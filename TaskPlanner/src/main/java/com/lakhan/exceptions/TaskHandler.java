package com.lakhan.exceptions;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class TaskHandler extends ResponseEntityExceptionHandler {

	
	  @ExceptionHandler(value = TaskException.class)
	    public ResponseEntity<String>handleCustomEx(Exception ex, WebRequest request)
	    {
	        String s=ex.getLocalizedMessage();
	        return new ResponseEntity<String>(s,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }


	    //@ExceptionHandler(value = MethodArgumentNotValidException.class)
	    public ResponseEntity<String>validationException(MethodArgumentNotValidException ex, WebRequest request)
	    {
	        BindingResult s=ex.getBindingResult();
	        return new ResponseEntity<String>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
	    }

	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        return super.handleMethodArgumentNotValid(ex, headers, status, request);
	    }
}
