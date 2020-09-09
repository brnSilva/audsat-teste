package br.com.audsat.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.audsat.config.PropertiesConfig;
import br.com.audsat.dto.ProdutoDTO;

@SpringBootTest
public class ComDescontoComponentTest {

	@Autowired
	private ComDescontoComponent comDescontoComponent;
	
	@Autowired
	private PropertiesConfig propertiesConfig;
	
	@Test
	void testObtemValorComDescontoComCentavos() {
		
		var retorno = comDescontoComponent.desconto(670.79d, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("915,63")
								.desconto("70,43")
								.comissao("33,54")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComDesconto() {
		
		var retorno = comDescontoComponent.desconto(5000.0, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("6.825,00")
								.desconto("525,00")
								.comissao("250,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComDescontoComCentavosAcimaMil() {
		
		var retorno = comDescontoComponent.desconto(5009.99, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("6.838,64")
								.desconto("526,05")
								.comissao("250,50")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComDescontoEmMilhoes() {
		
		var retorno = comDescontoComponent.desconto(1500420.0, propertiesConfig);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("2.048.073,30")
								.desconto("157.544,10")
								.comissao("75.021,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorEntradaValorNull() {
		assertThrows(Exception.class, () -> comDescontoComponent.desconto(null, propertiesConfig));
	}
	
	@Test
	void testObtemValorEntradaComissaoTotalInvalid() {
		assertThrows(Exception.class, () -> comDescontoComponent.desconto(Double.parseDouble("1.1.23.1"), propertiesConfig));
	}
}
