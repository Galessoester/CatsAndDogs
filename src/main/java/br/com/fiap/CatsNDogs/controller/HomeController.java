package br.com.fiap.CatsNDogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("mensagem", "Enviado pelo servidor");
		model.addAttribute("nome", "Ester Galesso Lopes dos Santos");
		
		return "home";
	}
}
