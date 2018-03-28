package com.financeiro.caixinha.data;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financeiro.caixinha.model.Pessoa;
import com.financeiro.caixinha.model.financeiro.ContaEmprestimo;

public interface ContaEmprestimoData extends JpaRepository<ContaEmprestimo, Long>{

	public List<ContaEmprestimo> findByPessoa(Pessoa pessoa);
	
	@Query("SELECT SUM(valor) FROM ContaEmprestimo")
	public BigDecimal totalLancamentos();
	
	@Query("SELECT c.pessoa, SUM(c.valor) FROM ContaEmprestimo c GROUP BY c.pessoa")
	public List<ContaEmprestimo> listaPessoasEmprestimo();

}
