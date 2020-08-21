package br.com.audsat.interfaces;

import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.utils.ValoresPropertiesUtil;

public interface CalculaValorInterface {
	
	public ProdutoDTO desconto(Double valor, ValoresPropertiesUtil valoresPropertiesUtil);

}
