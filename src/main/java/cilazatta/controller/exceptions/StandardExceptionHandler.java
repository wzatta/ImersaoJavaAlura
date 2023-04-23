package cilazatta.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cilazatta.service.exceptions.FieldDataIntegrityViolationException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class StandardExceptionHandler  {

	@ExceptionHandler(FieldDataIntegrityViolationException.class)
	public ResponseEntity<StandardError> recordExisting(
			FieldDataIntegrityViolationException e, HttpServletRequest request
			){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Registro Existente",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
	
}
