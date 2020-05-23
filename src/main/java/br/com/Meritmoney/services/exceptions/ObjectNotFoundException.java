package br.com.Meritmoney.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException(String exception) {
		
		super(exception);
	}
	

}
