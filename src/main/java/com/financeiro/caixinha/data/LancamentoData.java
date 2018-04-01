package com.financeiro.caixinha.data;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financeiro.caixinha.model.Pessoa;
import com.financeiro.caixinha.model.financeiro.Lancamento;

public interface LancamentoData extends JpaRepository<Lancamento, Long>{

	public List<Lancamento> findByPessoa(Pessoa pessoa);
	
	@Query("SELECT SUM(valor) FROM Lancamento")
	public BigDecimal totalLancamentos();
	
	@Query("SELECT c.pessoa, SUM(c.valor) FROM Lancamento c GROUP BY c.pessoa")
	public List<Lancamento> listaPessoasEmprestimo();

	
    //public List<Lancamento> listaPessoaLancamento();
}
