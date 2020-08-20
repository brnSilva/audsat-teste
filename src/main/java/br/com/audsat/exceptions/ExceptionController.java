package br.com.audsat.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

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
