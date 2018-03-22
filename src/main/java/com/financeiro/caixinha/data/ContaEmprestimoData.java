package com.financeiro.caixinha.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.caixinha.model.Pessoa;
import com.financeiro.caixinha.model.financeiro.ContaEmprestimo;

public interface ContaEmprestimoData extends JpaRepository<ContaEmprestimo, Long>{

	public List<ContaEmprestimo> findByPessoa(Pessoa pessoa);

}
