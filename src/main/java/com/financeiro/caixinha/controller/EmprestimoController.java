package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.EmprestimoData;
import com.financeiro.caixinha.data.JurosData;
import com.financeiro.caixinha.data.LancamentoData;
import com.financeiro.caixinha.data.PessoaData;
import com.financeiro.caixinha.model.Cooperado;
import com.financeiro.caixinha.model.Pessoa;
import com.financeiro.caixinha.model.SimulacaoEmprestimo;
import com.financeiro.caixinha.model.financeiro.Emprestimo;
import com.financeiro.caixinha.model.financeiro.Juros;
import com.financeiro.caixinha.model.financeiro.Lancamento;
import com.financeiro.caixinha.model.financeiro.TipoLancamento;

@Controller
public class EmprestimoController {
	
	@Autowired
	private EmprestimoData emprestimoData;

	@Autowired
	private PessoaData pessoaData;

	@Autowired
	private LancamentoData lancamentoData;
	
	@Autowired
	private JurosData jurosData;
	
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
		model.addAttribute("pessoas", pessoaData.findAll());
		return "emprestimo/cadastrar";
	}
	
	@PostMapping("/emprestimo/cadastrar")
	public String emprestimoSalvar(Emprestimo emprestimo, Juros juros, Model model){
		juros.setEmprestimo(emprestimo);
		juros.setDataLancamento(emprestimo.getDataEmprestimo());
		juros.setValor(juros.calculaJuros());
		jurosData.save(juros);
		emprestimoData.saveAndFlush(emprestimo);
		
		return "redirect:/emprestimo/pesquisar";
	}
	
	@GetMapping("/emprestimo/pesquisar")
	public String emprestimoPesquisar(Model model){
		model.addAttribute("pessoas", pessoaData.findAll());
		return "emprestimo/pesquisar";
	}
	
	@GetMapping("/emprestimo/novoEmprestimo/{id}")
	public String novoEmprestimoByPessoa(@PathVariable Long id, Emprestimo emprestimo, Pessoa pessoa, Model model) {
		model.addAttribute("pessoa", pessoaData.findById(id).get());
		model.addAttribute("emprestimo", emprestimo);
		return "emprestimo/novoEmprestimo";
	}
	
	@GetMapping("/emprestimo/pesquisarEmprestimoPorPessoa/{id}")
	public String pesquisarById(@PathVariable Long id, Pessoa pessoa, Emprestimo emprestimo, Model model) {
		model.addAttribute("emprestimo", emprestimoData.findByPessoa(pessoa));
		return "emprestimo/pesquisarEmprestimoPorPessoa";
	}
	
	@GetMapping("/emprestimo/pesquisarExtratoPorEmprestimo/{id}")
	public String extratoByEmprestimo(@PathVariable Long id, Pessoa pessoa, Emprestimo emprestimo, Model model) {
		model.addAttribute("emprestimo", emprestimoData.findById(id).get());
		return "emprestimo/pesquisarExtratoPorEmprestimo";
	}
	
	
	@GetMapping("/emprestimo/pagamento/{id}")
	public String novoPagamentoByPessoa(@PathVariable Long id, Emprestimo emprestimo, Lancamento lancamento, Model model) {
		model.addAttribute("emprestimo", emprestimoData.findById(id).get());
		model.addAttribute("tipoLancamentos", TipoLancamento.values());
		model.addAttribute("lancamento", lancamento);
		return "emprestimo/pagamento";
	}
	
	@PostMapping("/lancamento/cadastrar")
	public String lancamentoSalvar(Lancamento lancamento, Emprestimo emprestimo, Model model){
		lancamentoData.saveAndFlush(lancamento);
		return "redirect:/emprestimo/pesquisar";
	}
	
	
	
	
}
