package com.financeiro.caixinha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PagamentoController {
	
	@GetMapping("/pagamento/cadastrar")
	public String efetuaPagamento(@PathVariable("id") Long id) {
		
		return "redirect:/empresimo/pesquisar";
	}

}
