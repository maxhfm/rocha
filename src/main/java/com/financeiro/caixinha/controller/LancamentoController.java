package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.LancamentoData;
import com.financeiro.caixinha.data.PessoaData;
import com.financeiro.caixinha.model.Pessoa;
import com.financeiro.caixinha.model.financeiro.Lancamento;
import com.financeiro.caixinha.model.financeiro.TipoLancamento;

@Controller
public class LancamentoController {
	
	@Autowired
	private LancamentoData lancamentoData;

	@Autowired
	private PessoaData pessoaData;
	
	
	@GetMapping("/contaEmprestimo/cadastrar")
	public String emprestimo(Lancamento contaEmprestimo, Model model){	
		model.addAttribute("contaEmprestimo", contaEmprestimo);
		model.addAttribute("pessoas", pessoaData.findAll());
		model.addAttribute("tipoLancamentos", TipoLancamento.values());
		
		return "contaEmprestimo/cadastrar";
	}
	
	@GetMapping("/contaEmprestimo/pagar")
	public String pagar(Lancamento contaEmprestimo, Model model){
		model.addAttribute("contaEmprestimo", contaEmprestimo);
		model.addAttribute("pessoas", pessoaData.findAll());
		model.addAttribute("tipoLancamentos", TipoLancamento.values());
		return "contaEmprestimo/cadastrar";
	}
	
	@PostMapping("/contaEmprestimo/cadastrar")
	public String lancamentoSalvar(Lancamento contaEmprestimo, Model model){
		model.addAttribute("contaEmprestimo",lancamentoData.findByPessoa(contaEmprestimo.getPessoa()));
		if(contaEmprestimo.getTipoLancamento().equals("PAGAMENTO"))
			contaEmprestimo.setValor(contaEmprestimo.negativeValorPagamento());
		
		lancamentoData.saveAndFlush(contaEmprestimo);
		return "redirect:/contaEmprestimo/extrato";
	}
	
	
	@GetMapping("/contaEmprestimo/extrato")
	public String emprestimoPesquisar(Lancamento contaEmprestimo,Model model){
		model.addAttribute("pessoas", pessoaData.findAll());
		return "contaEmprestimo/extrato";
	}
	
	@GetMapping("/contaEmprestimo/extratoCliente/{id}")
	public String lancamentoCliente(@PathVariable Long id, Pessoa pessoa, Lancamento contaEmprestimo,Model model){
		model.addAttribute("pessoa", pessoaData.findById(id));
		return "contaEmprestimo/extratoCliente";
	}
	
}
