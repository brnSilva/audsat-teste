package br.com.audsat.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class FormataMascaraUtil {
	
	public String monetario(Double valor) {
		
		if(StringUtils.isEmpty(valor))
			return "0,00";
		
		var decimalFormatSymbols = new DecimalFormatSymbols();
		
		decimalFormatSymbols.setDecimalSeparator(',');
		decimalFormatSymbols.setGroupingSeparator('.');
		
		var decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
		
		return decimalFormat.format(valor);
	}
}
