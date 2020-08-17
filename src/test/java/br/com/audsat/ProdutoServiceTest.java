package br.com.audsat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.service.ProdutoService;

class ProdutoServiceTest {

	@Autowired
	private ProdutoService produtoService = new ProdutoService();
	
	@Test
	void testObtemValorComComissaoSemDesconto() {
		
		var retorno = produtoService.obtemValorComComissao(500.0);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("735,00")
								.desconto("0,00")
								.comissao("25,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}
	
	@Test
	void testObtemValorComComissaoComDesconto() {
		
		var retorno = produtoService.obtemValorComComissao(5000.0);
		
		var retornoEsperado = ProdutoDTO.builder()
								.valorTotal("6.825,00")
								.desconto("525,00")
								.comissao("250,00")
								.build();
		
		assertEquals(retornoEsperado, retorno);
	}

}
