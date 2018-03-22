package com.financeiro.caixinha.model.financeiro;

public enum TipoLancamento {
	
	EMPRESTIMO(1), PAGAMENTO(2);
	
	private final int tipo;
	
    TipoLancamento(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	} 
    
    

}
