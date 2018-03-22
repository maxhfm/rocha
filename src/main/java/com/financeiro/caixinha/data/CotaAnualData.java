package com.financeiro.caixinha.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.caixinha.model.CotaAnual;

public interface CotaAnualData extends JpaRepository<CotaAnual, Long> {

}
