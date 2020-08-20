package br.com.audsat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.audsat.components.FormataMascaraComponent;
import br.com.audsat.components.ValoresComponent;
import br.com.audsat.dto.ProdutoDTO;

@Service
public class ProdutoService {
	
	@Autowired
	private FormataMascaraComponent formataMascara;
	
	@Autowired
	private ValoresComponent valoresComponent;
	
	private Double comissaoTotal;
	
	public ProdutoDTO obterValor(Double valor) {

		var descontoTotal = 0.0d;
		
		comissaoTotal = (valor * valoresComponent.getComissaoVendedor());
		
		valor += comissaoTotal;
		
		if(valor >= valoresComponent.getValorDesconto()) {
			
			descontoTotal = (valor * valoresComponent.getDescontoCliente());
			valor += (valor * valoresComponent.getLucroVendaDesconto());
			
		} else {
			
			valor += (valor * valoresComponent.getLucroVenda());
			
		}

		return ProdutoDTO.builder()
				.valorTotal(formataMascara.monetario(valor))
				.desconto(formataMascara.monetario(descontoTotal))
				.comissao(formataMascara.monetario(comissaoTotal))
				.build();
	}
}
