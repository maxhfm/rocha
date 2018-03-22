package com.financeiro.caixinha.model.financeiro;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.financeiro.caixinha.model.Mensalidade;

@Entity
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Receita() {
		super();
	}
	public Receita(Long id) {
		super();
		this.id = id;
	}
	
	
	
	
	
	

}
