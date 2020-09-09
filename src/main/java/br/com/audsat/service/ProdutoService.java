package br.com.audsat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audsat.components.ComDescontoComponent;
import br.com.audsat.components.SemDescontoComponent;
import br.com.audsat.config.PropertiesConfig;
import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.interfaces.CalculaValorInterface;

@Service
public class ProdutoService  {
	
	@Autowired
	private PropertiesConfig PropertiesConfig;
	
	private CalculaValorInterface calculaValor;
	
	public ProdutoDTO obterValor(Double valor) {
		
		if(valor >= PropertiesConfig.getValorDesconto()) {
			
			calculaValor = new ComDescontoComponent();
			
		} else {
			
			calculaValor = new SemDescontoComponent();
		}

		return calculaValor.desconto(valor, PropertiesConfig);
	}
}
