package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.EmprestimoData;
import com.financeiro.caixinha.data.LancamentoData;
import com.financeiro.caixinha.model.financeiro.Emprestimo;
import com.financeiro.caixinha.model.financeiro.Lancamento;
import com.financeiro.caixinha.model.financeiro.TipoLancamento;

@Controller
public class LancamentoController {
	
	@Autowired
	private LancamentoData lancamentoData;
	
	@Autowired
	private EmprestimoData emprestimoData;
	
	
	
	
	
	
}
