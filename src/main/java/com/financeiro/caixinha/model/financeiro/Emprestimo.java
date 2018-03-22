package com.financeiro.caixinha.model.financeiro;

import java.time.LocalDate;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.financeiro.caixinha.model.Pessoa;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Pessoa pessoa;
	private float valor;
	private boolean status;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate data;
	
	
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Emprestimo(Long id, Pessoa pessoa, float valor, boolean status, LocalDate data) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.valor = valor;
		this.status = status;
		this.data = data;
	}
	public Emprestimo() {
		super();
	}
	
	
	
	
	
	
	
	
	

}
