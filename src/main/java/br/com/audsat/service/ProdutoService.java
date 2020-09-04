package br.com.audsat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audsat.components.ComDescontoComponent;
import br.com.audsat.components.SemDescontoComponent;
import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.interfaces.CalculaValorInterface;
import br.com.audsat.utils.ValoresPropertiesUtil;

@Service
public class ProdutoService {
	
	@Autowired
	private ValoresPropertiesUtil valoresPropertiesUtil;
	
	private CalculaValorInterface calculaValor;
	
	public ProdutoDTO obterValor(Double valor) {
		
		if(valor >= valoresPropertiesUtil.getValorDesconto()) {
			
			calculaValor = new ComDescontoComponent();
			
		} else {
			
			calculaValor = new SemDescontoComponent();
		}

		return calculaValor.desconto(valor, valoresPropertiesUtil);
	}
}
