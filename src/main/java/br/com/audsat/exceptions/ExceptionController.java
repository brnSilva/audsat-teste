package br.com.audsat.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionController extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class,
						MethodArgumentTypeMismatchException.class,
						NumberFormatException.class})
	public ResponseErroDTO exceptionEntradaInvalida(NumberFormatException e) {
		log.error(e.getMessage(), e);
		
		return ResponseErroDTO.builder()
				.erro(BAD_REQUEST.getReasonPhrase())
				.status(BAD_REQUEST.value())
				.mensagem("Número inválido. Exemplo de número válido: 1234.5")
				.build();
	}
	
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public ResponseErroDTO exceptionGenerica(Exception ex) {
		
		log.error(ex.getMessage(), ex);
		
		return ResponseErroDTO.builder()
				.erro(INTERNAL_SERVER_ERROR.getReasonPhrase())
				.status(INTERNAL_SERVER_ERROR.value())
				.mensagem("Ocorreu um erro ao tentar executar o calculo.")
				.build();
	}
	

}
