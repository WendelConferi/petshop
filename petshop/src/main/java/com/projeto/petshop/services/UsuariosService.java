package com.projeto.petshop.services;

import org.springframework.stereotype.Service;
import com.projeto.petshop.repositories.UsuariosRepository;

@Service
public class UsuariosService {

	final UsuariosRepository usuarioRepository;
	
	public UsuariosService(UsuariosRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
}
