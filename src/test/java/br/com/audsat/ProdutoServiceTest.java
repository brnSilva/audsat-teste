package br.com.audsat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.service.ProdutoService;

@SpringBootTest
class ProdutoServiceTest {

	@Autowired
	private ProdutoService produtoService = new ProdutoService();
	
	@Test
	void testObtemValorComComissaoSemDescontoComCentavos() {
		
		
		var retorno = produtoService.obterValor(456.32);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("670,79")
								.desconto("0,00")
								.comissao("22,82")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComComissaoSemDesconto() {
		
		var retorno = produtoService.obterValor(500.0);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("735,00")
								.desconto("0,00")
								.comissao("25,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComComissaoComDesconto() {
		
		var retorno = produtoService.obterValor(5000.0);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("6.825,00")
								.desconto("525,00")
								.comissao("250,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComComissaoComDescontoComCentavos() {
		
		var retorno = produtoService.obterValor(5009.99);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("6.838,64")
								.desconto("526,05")
								.comissao("250,50")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComComissaoComDescontoEmMilhoes() {
		
		var retorno = produtoService.obterValor(1500420.0);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("2.048.073,30")
								.desconto("157.544,10")
								.comissao("75.021,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}

}
