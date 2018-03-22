package com.financeiro.caixinha.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.caixinha.model.financeiro.Pagamento;



@Repository
public interface PagamentoData extends JpaRepository<Pagamento, Long>{

	

}
