package com.financeiro.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.financeiro.caixinha.data.ClienteData;
import com.financeiro.caixinha.data.CooperadoData;
import com.financeiro.caixinha.data.CotaAnualData;
import com.financeiro.caixinha.model.Cliente;
import com.financeiro.caixinha.model.Cooperado;
import com.financeiro.caixinha.model.CotaAnual;


@Controller
public class PessoaController {
	
	@Autowired
	CooperadoData cooperadoData;
	@Autowired
	ClienteData clienteData;
	@Autowired
	CotaAnualData cotaAnualPersistencia;
	
	
	@GetMapping("/pessoa/cooperado/cadastrar")
	public String salvar(Cooperado cooperado, CotaAnual cotaAnual, Model model){
		model.addAttribute("cooperado", cooperado);
		model.addAttribute("cotas", cotaAnualPersistencia.findAll());
		return "pessoa/cooperado/cadastrar";
	}
	
	@PostMapping("/pessoa/cooperado/cadastrar")
	public String salvarCooperado(Cooperado cooperado){
		cooperadoData.saveAndFlush(cooperado);
		return "redirect:/pessoa/cooperado/pesquisar";
	}
	
	@GetMapping("/pessoa/cooperado/pesquisar")
	public String pesquisar(Model model){
		model.addAttribute("cooperados", cooperadoData.findAll());
		return "pessoa/cooperado/pesquisar";
	}
	
	@GetMapping("/pessoa/cooperado/excluir/{id}")
	public String excluir(@PathVariable Long id){
		cooperadoData.deleteById(id);
		return "redirect:/pessoa/cooperado/pesquisar";
	}
	
	@GetMapping("/pessoa/cooperado/editar/{id}")
	public String editar(@PathVariable Long id, Model model){
		model.addAttribute("cooperado", cooperadoData.findById(id));
		model.addAttribute("cotas", cotaAnualPersistencia.findAll());
		return "pessoa/cooperado/editar";
	}
	
	
	//Cliente
	
	@GetMapping("/pessoa/cliente/cadastrar")
	public String salvarCliente(Model model, Cliente cliente){
		model.addAttribute("cliente", cliente);
		return "pessoa/cliente/cadastrar";
	}
	
	@PostMapping("/pessoa/cliente/cadastrar")
	public String salvarCliente(Cliente cliente){
		clienteData.saveAndFlush(cliente);
		return "redirect:/emprestimo/pesquisar";
	}
	
	@GetMapping("/pessoa/cliente/pesquisar")
	public String pesquisarCliente(Model model){
		model.addAttribute("clientes", clienteData.findAll());
		return "pessoa/cliente/pesquisar";
	}
	
	@GetMapping("/pessoa/cliente/excluir/{id}")
	public String excluirCliente(@PathVariable Long id){
		clienteData.deleteById(id);
		return "redirect:/pessoa/cliente/pesquisar";
	}
	
	@GetMapping("/pessoa/cliente/editar/{id}")
	public String editarCliente(@PathVariable Long id, Model model){
		model.addAttribute("cliente", clienteData.findById(id));
		return "pessoa/cliente/editar";
	}
	
	
	
	
}
