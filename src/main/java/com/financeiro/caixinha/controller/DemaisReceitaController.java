package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.ReceitaData;
import com.financeiro.caixinha.model.financeiro.Receita;


@Controller
public class DemaisReceitaController {
	@Autowired
	ReceitaData receitaData;
	
	@GetMapping("/demaisReceitas/cadastrar")
	public String cadastrarReceita(Receita receita, Model model) {
		model.addAttribute("receita", receita);
		return "demaisReceitas/cadastrar";
	}
	
	@PostMapping("/demaisReceitas/cadastrar")
	public String salvarReceita(Receita receita) {
		receitaData.save(receita);
		return "demaisReceitas/cadastrar";
	}

}
