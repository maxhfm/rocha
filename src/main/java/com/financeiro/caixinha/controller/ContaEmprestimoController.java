package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.ContaEmprestimoData;
import com.financeiro.caixinha.data.PessoaData;
import com.financeiro.caixinha.model.financeiro.ContaEmprestimo;
import com.financeiro.caixinha.model.financeiro.TipoLancamento;

@Controller
public class ContaEmprestimoController {
	
	@Autowired
	private ContaEmprestimoData contaEmprestimoData;

	@Autowired
	private PessoaData pessoas;
	
	
	
	@GetMapping("/contaEmprestimo/cadastrar")
	public String emprestimo(ContaEmprestimo contaEmprestimo, Model model){	
		model.addAttribute("contaEmprestimo", contaEmprestimo);
		model.addAttribute("pessoas", pessoas.findAll());
		model.addAttribute("tipoLancamentos", TipoLancamento.values());
		return "contaEmprestimo/cadastrar";
	}
	
	@GetMapping("/contaEmprestimo/pagar")
	public String pagar(ContaEmprestimo contaEmprestimo, Model model){
		model.addAttribute("contaEmprestimo", contaEmprestimo);
		model.addAttribute("pessoas", pessoas.findAll());
		model.addAttribute("tipoLancamentos", TipoLancamento.values());
		return "contaEmprestimo/cadastrar";
	}
	
	@PostMapping("/contaEmprestimo/cadastrar")
	public String lancamentoSalvar(ContaEmprestimo contaEmprestimo, Model model){
		
		model.addAttribute("contaEmprestimo",contaEmprestimoData.findByPessoa(contaEmprestimo.getPessoa()));
		if(contaEmprestimo.getTipoLancamento().equals("PAGAMENTO"))
			contaEmprestimo.setValor(contaEmprestimo.negativeValorPagamento());
		
		contaEmprestimoData.saveAndFlush(contaEmprestimo);
		return "redirect:/contaEmprestimo/extrato";
	}
	
	
	@GetMapping("/contaEmprestimo/extrato")
	public String emprestimoPesquisar(ContaEmprestimo contaEmprestimo,Model model){
		String num = "";
		model.addAttribute("contaEmprestimo", contaEmprestimoData.findAll());
		
		model.addAttribute("totalLancamentos", contaEmprestimoData.totalLancamentos());
		model.addAttribute("zero", num);
		return "contaEmprestimo/extrato";
	}
}
