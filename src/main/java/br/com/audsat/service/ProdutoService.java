package br.com.audsat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.enums.TipoCalculoEnum;
import br.com.audsat.interfaces.CalculaValorInterface;
import br.com.audsat.utils.ValoresPropertiesUtil;

@Service
public class ProdutoService {
	
	@Autowired
	private ValoresPropertiesUtil valoresPropertiesUtil;
	
	private TipoCalculoEnum tipoCalculo;
	
	private CalculaValorInterface calculaValor;
	
	public ProdutoDTO obterValor(Double valor) {
		
		if(valor >= valoresPropertiesUtil.getValorDesconto()) {
			
			tipoCalculo = TipoCalculoEnum.values()[0];
			
		} else {
			
			tipoCalculo = TipoCalculoEnum.values()[1];

		}
		
		calculaValor = tipoCalculo.obterTipoCalculo();

		return calculaValor.desconto(valor, valoresPropertiesUtil);
	}
}
