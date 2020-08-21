package br.com.audsat.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.audsat.service.ProdutoService;

@SpringBootTest
public class ProdutoServiceTest {
	
	@Autowired
	private ProdutoService produtoService = new ProdutoService();
	
	@Test
	void testObtemValorEntradaNull() {
		assertThrows(Exception.class, () -> produtoService.obterValor(null));
	}
	
	@Test
	void testObtemValorEntradaEmBranco() {
		assertThrows(Exception.class, () -> produtoService.obterValor(Double.parseDouble("")));
	}
	
	@Test
	void testObtemValorEntradaNumeroInvalido() {
		assertThrows(Exception.class, () -> produtoService.obterValor(Double.parseDouble("1.02.23.4")));
	}
}
