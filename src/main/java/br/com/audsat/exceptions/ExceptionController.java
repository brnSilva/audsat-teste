package br.com.audsat.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionController extends RuntimeException {

	private static final long serialVersionUID = 1L;

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
