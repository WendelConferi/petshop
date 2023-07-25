package com.projeto.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto.petshop.dtos.UsuariosDto;
import com.projeto.petshop.repositories.UsuariosRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UsuariosRepository usuarioRepositorio;
	
	@GetMapping("/login")
	public String index() {
		return "login/index";
	}
	
	@PostMapping("/logar")
	public String logar(Model model, UsuariosDto usuario) {
		
		return "login/index";
	}
	
} 