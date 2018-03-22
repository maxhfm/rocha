package com.financeiro.caixinha.model;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SimulacaoEmprestimo {
	
	private float emprestimo;
    private int parcelas;
    private float primeiroPagamento;
   
    public List<Float> calculoSimulacaoEmprestimo() {
		List<Float> simulacaoEmprestimo = new ArrayList<>();
		float resultado;
		System.out.println("Emprestimo: " + this.emprestimo + "Parcela: " + this.parcelas);
		float valorParcela = this.emprestimo / this.parcelas;
		System.out.println("valor da parcela " + valorParcela);
		for (int i = 0; i < this.parcelas; i++) {
			
			float juros = (float) (this.emprestimo * 0.1);
			resultado = (float) (valorParcela + juros);
			System.out.println("Valor Parcela " + i + ": " + resultado);
			setEmprestimo(this.emprestimo - valorParcela);
			simulacaoEmprestimo.add(resultado);
		}
	
		return simulacaoEmprestimo;
	}
	
	
	/*
	public List<JurosValor> calculoSimulacaoEmprestimoComPrimeiraParcela() {
		JurosValor jurosValor = new JurosValor();
		float vetorEmprestimoParcelado[] = new float[this.parcelas];
		vetorEmprestimoParcelado[0] = this.primeiroPagamento;
		float parcela = (this.emprestimo - this.primeiroPagamento) / (this.parcelas -1);
		
		for (int i = 1; i < this.parcelas; i++) {
			vetorEmprestimoParcelado[i] = parcela;
		}
		
		for (int i = 0; i < this.parcelas; i++) {
			jurosValor.setJuros((float) (this.emprestimo * 0.1));
			jurosValor.setValor((float) (vetorEmprestimoParcelado[i] + jurosValor.getJuros()));
			
			System.out.println("Valor Parcela " + i + ": " + jurosValor.getValor() + " - Juros: " + jurosValor.getJuros() );
			simulacaoEmprestimoUsandoModelTeste.add(jurosValor);
			setEmprestimo(this.emprestimo - vetorEmprestimoParcelado[i]);
		}
		
		return simulacaoEmprestimoUsandoModelTeste;
	}
	
	*/
	public TreeMap<Float, Float> calculoSimulacaoEmprestimoComPrimeiraParcela() {
			TreeMap<Float, Float> mapEmprestimo = new TreeMap<Float, Float>();	
			float resultado;
			float vetorEmprestimoParcelado[] = new float[this.parcelas];
			vetorEmprestimoParcelado[0] = this.primeiroPagamento;
			float parcela = (this.emprestimo - this.primeiroPagamento) / (this.parcelas -1);
			
			for (int i = 1; i < this.parcelas; i++) {
				vetorEmprestimoParcelado[i] = parcela;
			}
			
			for (int i = 0; i < this.parcelas; i++) {
				float juros = Math.round((float) (this.emprestimo * 0.1));
				resultado = Math.round((float) (vetorEmprestimoParcelado[i] + juros));
				
				//System.out.println("Valor Parcela " + i + ": " + resultado + " - Juros: " + juros );
				mapEmprestimo.put(juros, resultado);
				//mapEmprestimo1.put(Integer.toString(i), mapEmprestimo);
				System.out.println("Parcela" + vetorEmprestimoParcelado[i]);
				System.out.println("Juros" + mapEmprestimo.values());
				System.out.println("A pagar" + mapEmprestimo.keySet() + "\n");
				
				setEmprestimo(this.emprestimo - vetorEmprestimoParcelado[i]);
			}
			
		return mapEmprestimo;
	}


	public float getEmprestimo() {
		return emprestimo;
	}


	public void setEmprestimo(float emprestimo) {
		this.emprestimo = emprestimo;
	}


	

	public int getParcelas() {
		return parcelas;
	}


	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}


	public float getPrimeiroPagamento() {
		return primeiroPagamento;
	}


	public void setPrimeiroPagamento(float primeiroPagamento) {
		this.primeiroPagamento = primeiroPagamento;
	}


	public SimulacaoEmprestimo(float emprestimo, int parcelas, float primeiroPagamento) {
		super();
		this.emprestimo = emprestimo;
		this.parcelas = parcelas;
		this.primeiroPagamento = primeiroPagamento;
	}


	public SimulacaoEmprestimo() {
		super();
	}

	 
	
	
}