package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.DespesaData;
import com.financeiro.caixinha.model.financeiro.Despesa;


@Controller
public class DemaisDespesaController {
	
	@Autowired
	DespesaData despesaData;
	
	@GetMapping("/demaisDespesas/cadastrar")
	public String cadastrarDespesa(Despesa despesa, Model model) {
		model.addAttribute("despesa", despesa);
		return "demaisDespesas/cadastrar";
	}
	
	@PostMapping("/demaisDespesas/cadastrar")
	public String salvarDespesa(Despesa despesa) {
		despesaData.save(despesa);
		return "demaisDespesas/cadastrar";
	}

}
