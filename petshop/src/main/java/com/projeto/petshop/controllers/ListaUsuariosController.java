package com.projeto.petshop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/criarUsuario")
	public String criarUsuario(Usuarios usuario) {
		usuariosService.save(usuario);
		return "redirect:/listaUsuarios";
	}
	
	@GetMapping("/excluiUsuario/{cpf}")
	public String excluiUsuario(@PathVariable String cpf) {
		Optional<Usuarios> usuario = usuariosService.findById(cpf);
		
		usuariosService.delete(usuario.get());
		return "redirect:/listaUsuarios";
	}
	
	@GetMapping("/editar/{cpf}")
	public String buscaUsuario(@PathVariable String cpf, Model model) {
		
		Optional<Usuarios> user = usuariosService.findById(cpf);
		try {
			model.addAttribute("usuario", user.get());
		} catch (Exception e) {
			return "redirect:/listaUsuarios";
		}
		return "users/editar";
	}
	
	@PostMapping("/alterar/{cpf}")
	public String alterarUsuario(@PathVariable String cpf, Usuarios user) {
		
		if(!usuariosService.exist(cpf)) {
			return "redirect:/listaUsuarios";
		}
		usuariosService.save(user);
			
		return "redirect:/listaUsuarios";
	}
	
}