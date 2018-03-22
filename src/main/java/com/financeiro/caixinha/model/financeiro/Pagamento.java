package com.financeiro.caixinha.model.financeiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Emprestimo emprestimo;
	private float valor;
	private float juros;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getJuros() {
		return juros;
	}
	public void setJuros(float juros) {
		this.juros = juros;
	}
	public Pagamento(Long id, Emprestimo emprestimo, float valor, float juros) {
		super();
		this.id = id;
		this.emprestimo = emprestimo;
		this.valor = valor;
		this.juros = juros;
	}
	

	
	

}
