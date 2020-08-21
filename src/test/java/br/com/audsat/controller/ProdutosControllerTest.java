package br.com.audsat.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.audsat.controllers.ProdutosController;

@SpringBootTest
public class ProdutosControllerTest {
	
	@Autowired
	private ProdutosController produtosController;
	
	@Test
	public void testEntradaValorNull() {
		assertThrows(Exception.class, () -> produtosController.obterValor(null));
	}
	
	@Test
	public void testEntradaValorVazio() {
		assertThrows(Exception.class, () -> produtosController.obterValor(BigDecimal.valueOf(Double.parseDouble(("")))));
	}
}
