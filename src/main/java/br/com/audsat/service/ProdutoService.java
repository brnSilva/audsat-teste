package br.com.audsat.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import br.com.audsat.dto.ProdutoDTO;

@Service
public class ProdutoService {

	public ProdutoDTO obtemValorComComissao(Double valor) {
	
		Double comissaoVendedor = 0.05;
		Double lucroVenda = 0.4;
		Double lucroVendaComDesconto = 0.3;
		Double descontoCliente = 0.1;
		Double valorParaDesconto = 5000.0;
		Double comissaoTotal;
		Double descontoTotal = 0.0;
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		
		comissaoTotal = (valor * comissaoVendedor);
		valor += comissaoTotal;
		
		if(valor >= valorParaDesconto) {
			descontoTotal = (valor * descontoCliente);
			valor += (valor * lucroVendaComDesconto);
		} else {
			valor += (valor * lucroVenda);
		}

		return ProdutoDTO.builder()
				.valorTotal("R$ "+df.format(valor))
				.desconto("R$ "+df.format(descontoTotal))
				.comissao("R$ "+df.format(comissaoTotal))
				.build();
	}
}
