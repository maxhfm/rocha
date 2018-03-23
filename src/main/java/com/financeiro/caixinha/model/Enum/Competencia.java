package com.financeiro.caixinha.model.Enum;

public enum Competencia {
	Jan(01), Fev(02), Mar(03), Abr(04), Maio(05), Jun(06), Jul(07), Ago(8), Set(9), Out(10), Nov(11), Dez(12);

	private final int competencia;

	Competencia(int competencia) {
		this.competencia = competencia;

	}

	public int getCompetencia() {
		return competencia;
	}
	
	

}
