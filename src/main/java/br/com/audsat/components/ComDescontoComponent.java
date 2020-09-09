package br.com.audsat.components;

import org.springframework.stereotype.Service;

import br.com.audsat.config.PropertiesConfig;
import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.interfaces.CalculaValorInterface;
import br.com.audsat.utils.FormataMascaraUtil;

@Service
public class ComDescontoComponent implements CalculaValorInterface {
	

	@Override
	public ProdutoDTO desconto(Double valor, PropertiesConfig propertiesConfig) {
		
		var formataMascara = new FormataMascaraUtil();
		
		var comissaoTotal = (valor * propertiesConfig.getComissaoVendedor());
		
		valor += comissaoTotal;
		
		var descontoTotal = (valor * propertiesConfig.getDescontoCliente());
		
		valor += (valor * propertiesConfig.getLucroVendaDesconto());
		
		return ProdutoDTO.builder()
					.valorTotal(formataMascara.monetario(valor))
					.desconto(formataMascara.monetario(descontoTotal))
					.comissao(formataMascara.monetario(comissaoTotal))
					.build();
	}

}
