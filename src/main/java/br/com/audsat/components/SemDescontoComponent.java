package br.com.audsat.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.interfaces.CalculaValorInterface;
import br.com.audsat.utils.FormataMascaraUtil;
import br.com.audsat.utils.ValoresPropertiesUtil;


@Component
public class SemDescontoComponent implements CalculaValorInterface {

	@Override
	public ProdutoDTO desconto(Double valor, ValoresPropertiesUtil valoresPropertiesUtil) {
		
		FormataMascaraUtil formataMascara = new FormataMascaraUtil();
		
		var comissaoTotal = (valor * valoresPropertiesUtil.getComissaoVendedor());
		
		valor += comissaoTotal;
		
		valor += (valor * valoresPropertiesUtil.getLucroVenda());
		
		return ProdutoDTO.builder()
					.valorTotal(formataMascara.monetario(valor))
					.comissao(formataMascara.monetario(comissaoTotal))
					.build();
	}

}
