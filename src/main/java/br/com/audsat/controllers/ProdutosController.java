package br.com.audsat.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.audsat.dto.ProdutoDTO;
import br.com.audsat.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/valor/{valor}")
	public ProdutoDTO obterValor(@PathVariable BigDecimal valor) {
		return produtoService.obterValor(valor.doubleValue());
	}

}
