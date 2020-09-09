package br.com.audsat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@Configuration
@ConfigurationProperties(value = "valor")
public class PropertiesConfig {
	
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
