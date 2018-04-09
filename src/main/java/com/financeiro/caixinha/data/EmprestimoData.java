package com.financeiro.caixinha.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.caixinha.model.Pessoa;
import com.financeiro.caixinha.model.financeiro.Emprestimo;

public interface EmprestimoData extends JpaRepository<Emprestimo, Long>{

	public List<Emprestimo> findByPessoa(Pessoa pessoa);
	

}
