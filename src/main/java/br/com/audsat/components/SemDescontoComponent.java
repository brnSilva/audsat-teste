package br.com.audsat.components;

import org.springframework.stereotype.Component;

import br.com.audsat.config.PropertiesConfig;
import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.interfaces.CalculaValorInterface;
import br.com.audsat.utils.FormataMascaraUtil;


@Component
public class SemDescontoComponent  implements CalculaValorInterface {

	@Override
	public ProdutoDTO desconto(Double valor, PropertiesConfig propertiesConfig) {
		
		FormataMascaraUtil formataMascara = new FormataMascaraUtil();
		
		var comissaoTotal = (valor * propertiesConfig.getComissaoVendedor());
		
		valor += comissaoTotal;
		
		valor += (valor * propertiesConfig.getLucroVenda());
		
		return ProdutoDTO.builder()
					.valorTotal(formataMascara.monetario(valor))
					.comissao(formataMascara.monetario(comissaoTotal))
					.build();
	}

}
