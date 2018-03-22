package com.financeiro.caixinha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CotaAnual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float valor;
	private String ano;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public CotaAnual(Long id, float valor, String ano) {
		super();
		this.id = id;
		this.valor = valor;
		this.ano = ano;
	}

	public CotaAnual() {
		super();
	}

}
