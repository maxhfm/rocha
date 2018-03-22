package com.financeiro.caixinha.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.caixinha.model.Cliente;

@Repository
public interface ClienteData extends JpaRepository<Cliente, Long>{



}
