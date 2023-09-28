package com.projeto.petshop.controllers_rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.petshop.dtos.UsuariosDto;
import com.projeto.petshop.models.Usuarios;
import com.projeto.petshop.services.UsuariosService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuariosController {
	
	final UsuariosService usuariosService;

	public UsuariosController(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<Object> cadastroUsuario(@RequestBody @Valid UsuariosDto usuarioDto){
		var usuario = new Usuarios();
		BeanUtils.copyProperties(usuarioDto, usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.save(usuario));
	}
	
	@GetMapping("/busca")
	public ResponseEntity<List<Usuarios>> buscaUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findAll());
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<Object> excluiUsuario(@PathVariable(value = "id") String cpf){
		Optional<Usuarios> usuario = usuariosService.findById(cpf);
		if(!usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
		}
		usuariosService.delete(usuario.get());
		return ResponseEntity.status(HttpStatus.OK).body("Usuário deleteado");
	}

}
