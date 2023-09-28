package com.projeto.petshop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projeto.petshop.dtos.UsuariosDto;
import com.projeto.petshop.models.Usuarios;
import com.projeto.petshop.services.UsuariosService;
import com.projeto.petshop.converter.*;

@Controller
public class ListaUsuariosController {
	
	private UsuariosConverter converter = new UsuariosConverter();
	
	@Autowired
	private UsuariosService usuariosService;
	
	@SuppressWarnings("static-access")
	@GetMapping("/listaUsuarios")
	public String index(Model model) {
	    List<Usuarios> usuarios = usuariosService.findAll();
	    List<UsuariosDto> listaUsuariosDto = new ArrayList<>();

	    for (Usuarios usuario : usuarios) {
	    	UsuariosDto usuariosDto = new UsuariosDto();
	    	
	    	listaUsuariosDto.add(converter.mapToDTO(usuario, usuariosDto));
	    }
		model.addAttribute("Usuarios", listaUsuariosDto);
		return "users/index";
	}
	
	@GetMapping("/cadastroUsuarios")
	public String cadastro() {

		return "users/cadastro";
	}
	
}