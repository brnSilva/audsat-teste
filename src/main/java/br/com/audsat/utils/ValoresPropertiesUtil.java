package br.com.audsat.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ValoresPropertiesUtil {
	
	@Value(value = "${valor.comissao.vendedor}")
	private Double comissaoVendedor;
	
	@Value(value = "${valor.lucro.venda}")
	private Double lucroVenda;
	
	@Value(value = "${valor.lucro.venda.desconto}")
	private Double lucroVendaDesconto;
	
	@Value(value = "${valor.desconto.cliente}")
	private Double descontoCliente;
	
	@Value(value = "${valor.desconto}")
	private Double valorDesconto;
}
