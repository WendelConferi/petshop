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

@Controller
public class ListaUsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping("/listaUsuarios")
	public String index(Model model) {
	    List<Usuarios> usuarios = usuariosService.findAll();
	    List<UsuariosDto> listaUsuariosDto = new ArrayList<>();

	    for (Usuarios usuario : usuarios) {
	    	UsuariosDto usuariosDto = new UsuariosDto();
	    	usuariosDto.setDesCpf(usuario.getDesCpf());
	    	usuariosDto.setDesNome(usuario.getDesNome());
	    	usuariosDto.setDesSenha(usuario.getDesSenha());
	    	usuariosDto.setIndTipo(usuario.getIndTipo());
	    	
	    	listaUsuariosDto.add(usuariosDto);
	    }
		
		
		model.addAttribute("Usuarios", listaUsuariosDto);
		return "users/index";
	}
	
}