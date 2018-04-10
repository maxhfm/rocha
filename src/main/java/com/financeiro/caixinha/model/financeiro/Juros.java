package com.financeiro.caixinha.model.financeiro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Juros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	private Emprestimo emprestimo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;

	private BigDecimal valor;

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

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Juros(Long id, Emprestimo emprestimo, LocalDate dataLancamento, BigDecimal valor) {
		super();
		this.id = id;
		this.emprestimo = emprestimo;
		this.dataLancamento = dataLancamento;
		this.valor = valor;
	}
	
	public Juros(Emprestimo emprestimo, LocalDate dataLancamento, BigDecimal valor) {
		super();
		this.emprestimo = emprestimo;
		this.dataLancamento = dataLancamento;
		this.valor = valor;
	}


	public Juros() {
		super();
	}
	
	public BigDecimal calculaJuros(){
		return this.emprestimo.getValor().multiply(new BigDecimal(0.1));
	}

}
