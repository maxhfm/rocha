package com.financeiro.caixinha.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.caixinha.model.Cooperado;

@Repository
public interface CooperadoData extends JpaRepository<Cooperado, Long>{



}
