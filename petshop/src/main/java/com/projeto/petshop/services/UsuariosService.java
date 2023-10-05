package com.projeto.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.petshop.models.Usuarios;
import com.projeto.petshop.repositories.UsuariosRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuariosService {

	final UsuariosRepository usuarioRepository;
	
	public UsuariosService(UsuariosRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Transactional
	public Usuarios save(Usuarios usuario) {
		usuario.setDesCpf(usuario.getDesCpf().replace(".", "").replace("-", ""));
		return usuarioRepository.save(usuario);
	}

	public List<Usuarios> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuarios> findById(String cpf){
		return usuarioRepository.findById(cpf);
	}
	
	@Transactional
	public void delete(Usuarios usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public boolean exist(String cpf){
		return usuarioRepository.existsById(cpf);
	}
}
