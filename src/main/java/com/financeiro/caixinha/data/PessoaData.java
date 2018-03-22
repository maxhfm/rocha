package com.financeiro.caixinha.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.caixinha.model.Pessoa;

public interface PessoaData extends JpaRepository<Pessoa, Long>{

}
