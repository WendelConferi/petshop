package com.projeto.petshop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.projeto.petshop.controllers_rest.UsuariosController;
import com.projeto.petshop.dtos.UsuariosDto;
import com.projeto.petshop.models.Usuarios;
import com.projeto.petshop.services.UsuariosService;
import java.net.*;

@Controller
public class ListaUsuariosController {

//	@Autowired
//	private UsuariosService usuariosService;
//	private UsuariosController usuarioControllerRest;
//	
//	@GetMapping("/listaUsuarios")
//	public String index(Model model) {
//	    List<Usuarios> usuarios = usuariosService.findAll();
//	    List<UsuariosDto> usuariosDto = new ArrayList<>();
//	    UsuariosDto usuarioDto = new UsuariosDto();
//
//	    for (Usuarios usuario : usuarios) {
//	       usuarioDto.setDesCpf(usuario.getDesCpf());
//	       usuarioDto.setDesNome(usuario.getDesNome());
//	       usuarioDto.setDesSenha(usuario.getDesSenha());
//	       usuarioDto.setIndTipo(usuario.getIndTipo());
//	       
//	       usuariosDto.add(usuarioDto);
//	    }
//
//	    model.addAttribute("Usuarios", usuariosDto);
//	    return "users/index";
//	}

	@GetMapping("/listaUsuarios")
	public String index(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "http://localhost:8080/usuarios/busca";

		ResponseEntity<List<Usuarios>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Usuarios>>() {
				});

		List<Usuarios> usuariosList = response.getBody();

		List<UsuariosDto> usuariosDto = new ArrayList<>();
		for (Usuarios usuario : usuariosList) {
			UsuariosDto dto = new UsuariosDto();
			dto.setDesCpf(usuario.getDesCpf());
			dto.setDesNome(usuario.getDesNome());
			dto.setDesSenha(usuario.getDesSenha());
			dto.setIndTipo(usuario.getIndTipo());
			
			usuariosDto.add(dto);
		}

		model.addAttribute("Usuarios", usuariosDto);
		return "users/index";
	}

}