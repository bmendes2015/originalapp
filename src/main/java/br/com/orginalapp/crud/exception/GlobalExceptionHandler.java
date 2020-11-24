package br.com.orginalapp.crud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<?> recursoNaoEncontradoException(RecursoNaoEncontradoException ex, WebRequest request) {
		ErroDetalhes erroDetalhes = new ErroDetalhes(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception ex, WebRequest request) {
		ErroDetalhes erroDetalhes = new ErroDetalhes(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(erroDetalhes, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
