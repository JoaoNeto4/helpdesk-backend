package br.com.helpdesk.helpdesk.resource.excetions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.helpdesk.helpdesk.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFounfException(ObjectNotFoundException ex, HttpServletRequest request){
		StandardError error = new StandardError(
				System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(),
				"Object not found",
				ex.getMessage(),
				request.getRequestURI()
			);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
