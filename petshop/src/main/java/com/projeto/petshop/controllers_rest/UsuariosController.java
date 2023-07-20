package com.projeto.petshop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.petshop.services.UsuariosService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuariosController {
	
	final UsuariosService usuariosService;

	public UsuariosController(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}

}
