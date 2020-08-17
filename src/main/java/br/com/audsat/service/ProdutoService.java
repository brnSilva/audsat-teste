package br.com.audsat.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import br.com.audsat.dto.ProdutoDTO;

@Service
public class ProdutoService {

	public ProdutoDTO obtemValorComComissao(Double valor) {
	
		var comissaoVendedor = 0.05;
		var lucroVenda = 0.4;
		var lucroVendaComDesconto = 0.3;
		var descontoCliente = 0.1;
		var valorParaDesconto = 5000.0;
		var comissaoTotal = 0.0;
		var descontoTotal = 0.0;
		var df = new DecimalFormat("###,###,##0.00");
		
		comissaoTotal = (valor * comissaoVendedor);
		valor += comissaoTotal;
		
		if(valor >= valorParaDesconto) {
			descontoTotal = (valor * descontoCliente);
			valor += (valor * lucroVendaComDesconto);
		} else {
			valor += (valor * lucroVenda);
		}

		return ProdutoDTO.builder()
				.valorTotal(df.format(valor))
				.desconto(df.format(descontoTotal))
				.comissao(df.format(comissaoTotal))
				.build();
	}
}
