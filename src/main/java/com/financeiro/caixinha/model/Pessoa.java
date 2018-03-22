package com.financeiro.caixinha.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.financeiro.caixinha.model.financeiro.Emprestimo;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String banco;
	private String agencia;
	private String conta;
	@OneToMany
	List<Emprestimo> listaEmprestimos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Pessoa(Long id, String nome, String banco, String agencia, String conta) {
		super();
		this.id = id;
		this.nome = nome;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
	}

	public Pessoa() {
		super();
	}

}
