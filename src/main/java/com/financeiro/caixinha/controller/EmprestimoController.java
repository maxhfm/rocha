package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.CooperadoData;
import com.financeiro.caixinha.data.EmprestimoData;
import com.financeiro.caixinha.data.PessoaData;
import com.financeiro.caixinha.model.Cooperado;
import com.financeiro.caixinha.model.SimulacaoEmprestimo;
import com.financeiro.caixinha.model.financeiro.Emprestimo;

@Controller
public class EmprestimoController {
	
	@Autowired
	private EmprestimoData emprestimoData;
	@Autowired
	private CooperadoData cooperados;
	@Autowired
	private PessoaData pessoas;
	
	
	@GetMapping("/emprestimo/simulacao")
	public String simulacao(SimulacaoEmprestimo emprestimo, Model model){
		model.addAttribute("emprestimo", emprestimo);
		return "emprestimo/simulacao";
	}
	
	@PostMapping("/emprestimo/retornoSimulacao")
	public String retornoSimulacao(SimulacaoEmprestimo emprestimo, Model model){
		model.addAttribute("emprestimo", emprestimo);
		return "emprestimo/retornoSimulacao";
	}
	
	@GetMapping("/emprestimo/cadastrar")
	public String emprestimo(Emprestimo emprestimo, Cooperado cooperado, Model model){
		model.addAttribute("emprestimo", emprestimo);
		model.addAttribute("pessoas", pessoas.findAll());
		return "emprestimo/cadastrar";
	}
	
	@PostMapping("/emprestimo/cadastrar")
	public String emprestimoSalvar(Emprestimo emprestimo, Model model){
		emprestimo.setStatus(false);
		emprestimoData.saveAndFlush(emprestimo);
		return "redirect:/emprestimo/pesquisar";
	}
	
	@GetMapping("/emprestimo/pesquisar")
	public String emprestimoPesquisar(Model model){
		model.addAttribute("emprestimos", emprestimoData.findAll());
		return "emprestimo/pesquisar";
	}
}
