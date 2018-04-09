package com.financeiro.caixinha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente(Long id, String nome, String banco, String agencia, String conta, Long id2) {
		super(id, nome, banco, agencia, conta);
		id = id2;
	}

	public Cliente() {
		super();
	}
	
	

	
	
	
	

	
	
	

	

}