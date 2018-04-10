package com.financeiro.caixinha.model.financeiro;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
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
	private LocalDate dataEmprestimo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataVencimento;

	@OneToMany(mappedBy = "emprestimo")
	List<Lancamento> lancamentos;
	
	@OneToMany(mappedBy = "emprestimo", cascade=CascadeType.ALL)
	List<Juros> juros;

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

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Emprestimo() {
		super();
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public List<Juros> getJuros() {
		return juros;
	}

	public void setJuros(List<Juros> juros) {
		this.juros = juros;
	}

	public Emprestimo(Long id, Pessoa pessoa, BigDecimal valor, LocalDate dataEmprestimo, LocalDate dataVencimento,
			List<Lancamento> lancamentos, List<Juros> juros) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.valor = valor;
		this.dataEmprestimo = dataEmprestimo;
		this.dataVencimento = dataVencimento;
		this.lancamentos = lancamentos;
		this.juros = juros;
	}

	public Emprestimo(Long id, Pessoa pessoa, BigDecimal valor, LocalDate dataEmprestimo, LocalDate dataVencimento,
			List<Lancamento> lancamentos) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.valor = valor;
		this.dataEmprestimo = dataEmprestimo;
		this.dataVencimento = dataVencimento;
		this.lancamentos = lancamentos;
	}

	public BigDecimal totalLancamentos() {
		NumberFormat formater = NumberFormat.getCurrencyInstance();
		BigDecimal totalLancamentos = BigDecimal.valueOf(0);
		for (Lancamento l : this.getLancamentos()) {
			totalLancamentos = totalLancamentos.add(l.getValor());
		}
		return totalLancamentos;
	}

	public BigDecimal saldoaPagar() {
		BigDecimal resultado = this.valor.subtract(totalLancamentos());
		BigDecimal totalJuros = BigDecimal.valueOf(0);
		for (Juros j : this.getJuros()) {
			totalJuros = totalJuros.add(j.getValor());
		}
		resultado = resultado.add(totalJuros);
		return resultado; 
	}

}
