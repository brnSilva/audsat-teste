package br.com.audsat.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.audsat.config.PropertiesConfig;
import br.com.audsat.dto.ProdutoDTO;

@SpringBootTest
public class SemDescontoComponentTest {
	
	@Autowired
	private SemDescontoComponent semDescontoComponent;
	
	@Autowired
	private PropertiesConfig propertiesConfig;
	
	@Test
	void testObtemValorSemDescontoComCentavos() {
		
		var retorno = semDescontoComponent.desconto(456.32, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("670,79")
								.desconto("0,00")
								.comissao("22,82")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorSemDesconto() {
		
		var retorno = semDescontoComponent.desconto(500.0, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("735,00")
								.desconto("0,00")
								.comissao("25,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void obtemValorSemDescontoComCentavos() {
		
		var retorno = semDescontoComponent.desconto(670.79, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("986,06")
								.desconto("0,00")
								.comissao("33,54")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void obtemValorSemDesconto() {
		
		var retorno = semDescontoComponent.desconto(2222.00, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("3.266,34")
								.desconto("0,00")
								.comissao("111,10")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorEntradaValorNull() {
		assertThrows(Exception.class, () -> semDescontoComponent.desconto(null, propertiesConfig));
	}
	
	@Test
	void testObtemValorEntradaComissaoTotalNull() {
		assertThrows(Exception.class, () -> semDescontoComponent.desconto(Double.parseDouble("11.55.2.10"), propertiesConfig));
	}
}
