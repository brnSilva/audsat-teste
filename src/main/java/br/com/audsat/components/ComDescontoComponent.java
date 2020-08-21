package br.com.audsat.components;

import org.springframework.stereotype.Component;

import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.interfaces.CalculaValorInterface;
import br.com.audsat.utils.FormataMascaraUtil;
import br.com.audsat.utils.ValoresPropertiesUtil;

@Component
public class ComDescontoComponent implements CalculaValorInterface {
	
	@Override
	public ProdutoDTO desconto(Double valor, ValoresPropertiesUtil valoresPropertiesUtil) {
		
		var formataMascara = new FormataMascaraUtil();
		
		var comissaoTotal = (valor * valoresPropertiesUtil.getComissaoVendedor());
		
		valor += comissaoTotal;
		
		var descontoTotal = (valor * valoresPropertiesUtil.getDescontoCliente());
		
		valor += (valor * valoresPropertiesUtil.getLucroVendaDesconto());
		
		return ProdutoDTO.builder()
					.valorTotal(formataMascara.monetario(valor))
					.desconto(formataMascara.monetario(descontoTotal))
					.comissao(formataMascara.monetario(comissaoTotal))
					.build();
	}

}
