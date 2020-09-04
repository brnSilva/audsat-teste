//package br.com.audsat.enums;
//
//import br.com.audsat.components.ComDescontoComponent;
//import br.com.audsat.components.SemDescontoComponent;
//import br.com.audsat.interfaces.CalculaValorInterface;
//
//public enum TipoCalculoEnum {
//	COM_DESCONTO {
//		@Override
//		public CalculaValorInterface obterTipoCalculo() {
//			return new ComDescontoComponent();
//		}
//	},
//	SEM_DESCONTO {
//		@Override
//		public CalculaValorInterface obterTipoCalculo() {
//			return new SemDescontoComponent();
//		}
//	};
//	
//	public abstract CalculaValorInterface obterTipoCalculo();
//}
