package com.financeiro.caixinha.model.financeiro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.financeiro.caixinha.model.Pessoa;

@Entity
public class ContaEmprestimo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Pessoa pessoa;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataLancamento;
	
	private String tipoLancamento;
	
	private BigDecimal valor;

	public ContaEmprestimo() {
		// TODO Auto-generated constructor stub
	}
	


	public ContaEmprestimo(Long id, Pessoa pessoa, LocalDate dataLancamento, String tipoLancamento, BigDecimal valor) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.dataLancamento = dataLancamento;
		this.tipoLancamento = tipoLancamento;
		this.valor = valor;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	
}