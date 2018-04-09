package com.financeiro.caixinha.model.financeiro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Emprestimo emprestimo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;

	private String tipoLancamento;

	private BigDecimal valor;

	public Lancamento() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Lancamento(Long id, Emprestimo emprestimo, LocalDate dataLancamento, String tipoLancamento,
			BigDecimal valor) {
		super();
		this.id = id;
		this.emprestimo = emprestimo;
		this.dataLancamento = dataLancamento;
		this.tipoLancamento = tipoLancamento;
		this.valor = valor;
	}

	public BigDecimal negativeValorPagamento() {
		BigDecimal pagamentoNegativo = this.valor;
		return pagamentoNegativo.negate();
	}

	/*
	 * public Map<Pessoa, Double> retornaSaldo(List<Lancamento> lista) {
	 * 
	 * Map<Pessoa, Double> valorSaldo = lista.stream().collect(Collectors
	 * .groupingBy(Emprestimo::getPessoa, Collectors.summingDouble(p ->
	 * p.valor.doubleValue()))); return valorSaldo; }
	 */

	public BigDecimal atualizaJuros(List<Lancamento> lancamentos) {
		BigDecimal saldo = BigDecimal.valueOf(0);
		for (Lancamento lancamento : lancamentos) {
			saldo = saldo.add(lancamento.getValor());
		}
		return saldo.multiply(new BigDecimal("0.1"));
	}

}