package br.com.audsat.components;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class FormataMascaraComponent {
	
	public String monetario(Double valor) {
		
		if(StringUtils.isEmpty(valor))
			return "0,00";
		
		var dfSymb = new DecimalFormatSymbols();
		
		dfSymb.setDecimalSeparator(',');
		dfSymb.setGroupingSeparator('.');
		
		var df = new DecimalFormat("#,##0.00", dfSymb);
		
		return df.format(valor);
	}
}
