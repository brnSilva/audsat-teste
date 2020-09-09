package br.com.audsat.interfaces;

import org.springframework.stereotype.Repository;

import br.com.audsat.config.PropertiesConfig;
import br.com.audsat.dto.ProdutoDTO;

@Repository
public interface CalculaValorInterface {
	
	public ProdutoDTO desconto(Double valor, PropertiesConfig propertiesConfig);

}
