package br.com.audsat.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ValoresComponent {
	
	@Value("${valor.comissao.vendedor}")
	private Double comissaoVendedor;
	
	@Value("${valor.lucro.venda}")
	private Double lucroVenda;
	
	@Value("${valor.lucro.venda.desconto}")
	private Double lucroVendaDesconto;
	
	@Value("${valor.desconto.cliente}")
	private Double descontoCliente;
	
	@Value("${valor.desconto}")
	private Double valorDesconto;
}
