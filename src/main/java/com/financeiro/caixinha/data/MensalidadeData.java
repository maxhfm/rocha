package com.financeiro.caixinha.data;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.financeiro.caixinha.model.Mensalidade;

@Repository
public interface MensalidadeData extends JpaRepository<Mensalidade, Long>{
	
	//@Query(value="SELECT c.id,c.nome,m.competencia,m.valor FROM pessoa c LEFT JOIN mensalidade m ON c.id=m.id_cooperado_id ORDER BY c.nome asc", nativeQuery=true)
	//@Query("SELECT m FROM Mensalidade m RIGHT JOIN m.idCooperado")
	//List<Mensalidade> listaMensalidadesTodosCooperados();
	
	
	//SELECT e FROM Employee e ORDER BY e.lastName ASC, e.firstName, ASC



}
