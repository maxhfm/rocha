package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.CotaAnualData;
import com.financeiro.caixinha.model.CotaAnual;

@Controller
public class CotaAnualController {
	
	@Autowired
	private CotaAnualData cotaAnualPersistencia;
	
	@GetMapping("/cota/anual/cadastrar")
	public String salvar(CotaAnual cotaAnual, Model model) {
		model.addAttribute("cotaAnual", cotaAnual);
		return "cota/anual/cadastrar";
	}
	
	@PostMapping("/cota/anual/cadastrar")
	public String salvarCotaAnual(CotaAnual cotaAnual) {
		cotaAnualPersistencia.saveAndFlush(cotaAnual);
		return "redirect:/cota/anual/pesquisar";
	}

	@GetMapping("/cota/anual/pesquisar")
	public String pesquisarCotaAnual(Model model) {
		model.addAttribute("cotasAnual", cotaAnualPersistencia.findAll());
		return "cota/anual/pesquisar";
	}
}
