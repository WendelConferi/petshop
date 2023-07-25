package com.projeto.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListaUsuariosController {
	@GetMapping("/listaUsuarios")
	public String index() {
		return "users/index";
	}
	
}