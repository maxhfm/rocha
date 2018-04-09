package com.financeiro.caixinha.model.financeiro;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.financeiro.caixinha.model.Pessoa;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Pessoa pessoa;

	private BigDecimal valor;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	@OneToMany(mappedBy = "emprestimo")
	List<Lancamento> lancamentos;

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Emprestimo() {
		super();
	}

	public Emprestimo(Long id, Pessoa pessoa, BigDecimal valor, LocalDate data) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.valor = valor;
		this.data = data;
	}
	
	public BigDecimal totalLancamentos() {
		NumberFormat formater = NumberFormat.getCurrencyInstance();
		BigDecimal totalLancamentos = BigDecimal.valueOf(0);
		for (Lancamento l : this.getLancamentos()) {
			totalLancamentos = totalLancamentos.add(l.getValor());
		}
		return totalLancamentos;
	}
	
	public BigDecimal saldoaPagar(){
		NumberFormat formater = NumberFormat.getCurrencyInstance();
		return this.valor.subtract(totalLancamentos());
	}

}
