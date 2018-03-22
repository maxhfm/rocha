package com.financeiro.caixinha.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mensalidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cooperado idCooperado;
	
	private float valor;
	private String tipoPagamento;
	private String competencia;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cooperado getIdCooperado() {
		return idCooperado;
	}

	public void setIdCooperado(Cooperado idCooperado) {
		this.idCooperado = idCooperado;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Mensalidade() {
		super();
	}
	
	

	public Mensalidade(Long id, Cooperado idCooperado, float valor, String tipoPagamento, String competencia) {
		super();
		this.id = id;
		this.idCooperado = idCooperado;
		this.valor = valor;
		this.tipoPagamento = tipoPagamento;
		this.competencia = competencia;
	}

	public float calculoValorMensalidade() {
		return this.idCooperado.getValorCotaAnual().getValor() * this.idCooperado.getQuantidadeCota();
	}
	
	
	public float mensalidadeCompetencia() {
		
		return 0;
	}

	
		 
}
	
	
	
	
	


