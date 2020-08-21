package br.com.audsat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {
	
	private String valorTotal;
	
	@Default
	private String desconto = "0,00";
	
	private String comissao;
	
}
