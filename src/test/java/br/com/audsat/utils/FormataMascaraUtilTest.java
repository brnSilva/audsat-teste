package br.com.audsat.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FormataMascaraUtilTest {
	
	@Autowired
	private FormataMascaraUtil formataMascaraUtil;
	
	@Test
	public void testEntradaVazio() {
		assertThrows(Exception.class, () -> formataMascaraUtil.monetario(Double.parseDouble("1.2.3.4.5")));
	}
}
