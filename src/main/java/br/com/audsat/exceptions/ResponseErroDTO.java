package br.com.audsat.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseErroDTO {
	
	private Integer status;
	
	private String erro;
	
	private String mensagem;
}
