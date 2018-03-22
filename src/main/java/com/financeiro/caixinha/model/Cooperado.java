package com.financeiro.caixinha.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cooperado extends Pessoa{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer quantidadeCota;
	@ManyToOne
	private CotaAnual valorCotaAnual;
	
	//@OneToMany(mappedBy = "idCooperado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "idCooperado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Mensalidade> listaMensalidade;
	
	
	public List<Mensalidade> getListaMensalidade() {
		return listaMensalidade;
	}

	public void setListaMensalidade(List<Mensalidade> listaMensalidade) {
		this.listaMensalidade = listaMensalidade;
	}

	//Get Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidadeCota() {
		return quantidadeCota;
	}

	public void setQuantidadeCota(Integer quantidadeCota) {
		this.quantidadeCota = quantidadeCota;
	}

	public CotaAnual getValorCotaAnual() {
		return valorCotaAnual;
	}

	public void setValorCotaAnual(CotaAnual valorCotaAnual) {
		this.valorCotaAnual = valorCotaAnual;
	}

	

	public Cooperado(Long id, String nome, String banco, String agencia, String conta, Long id2, Integer quantidadeCota,
			CotaAnual valorCotaAnual) {
		super(id, nome, banco, agencia, conta);
		id = id2;
		this.quantidadeCota = quantidadeCota;
		this.valorCotaAnual = valorCotaAnual;
	}

	public Cooperado() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public float totalMensalidades() {
		return this.listaMensalidade.stream().map(Mensalidade::getValor).reduce(Float.valueOf(0f), (a, b) -> {
			return Float.sum(a, b);
		});
	}
	
	/*
	String competencia = "02/2018";
	public Stream<Mensalidade> totalMensalidadesporCompetencia() {
		
		return this.listaMensalidade.stream().map(Mensalidade::getCompetencia).re
	}
	*/


	
	
	
	
	
	

		
	

}
