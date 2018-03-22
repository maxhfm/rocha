package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.CooperadoData;
import com.financeiro.caixinha.data.MensalidadeData;
import com.financeiro.caixinha.model.Cooperado;
import com.financeiro.caixinha.model.Mensalidade;

@Controller
public class MensalidadeController {
	
	@Autowired
	MensalidadeData mensalidadePersistencia; 
	@Autowired
	CooperadoData cooperadoPersistencia;
	
	Cooperado cooperado = new Cooperado();
	
	@GetMapping("/mensalidade/cadastrar")
	public String salvar(Mensalidade mensalidade, Model model) {
		model.addAttribute("mensalidade", mensalidade);
		model.addAttribute("cooperados", cooperadoPersistencia.findAll());
		return "mensalidade/cadastrar";
	}
	
	@PostMapping("/mensalidade/cadastrar")
	public String salvarMensalidade(Mensalidade mensalidade) {
		mensalidade.setValor(mensalidade.calculoValorMensalidade());
		mensalidadePersistencia.saveAndFlush(mensalidade);
		return "redirect:/mensalidade/pesquisar";
	}
	
	@GetMapping("/mensalidade/pesquisar")
	public String pesquisarMensalidade(Model model) {
		model.addAttribute("mensalidades", mensalidadePersistencia.findAll());
		return "mensalidade/pesquisar";
	}
	
	@GetMapping("/mensalidade/pesquisarCompCooperado")
	public String pesquisarMensalidadeporCompetencia(Model model) {
		model.addAttribute("cooperados", cooperadoPersistencia.findAll());
		//model.addAttribute("mensalidades", mensalidadePersistencia.listaMensalidadesTodosCooperados());
		
		return "mensalidade/pesquisarCompCooperado";
	}
}
