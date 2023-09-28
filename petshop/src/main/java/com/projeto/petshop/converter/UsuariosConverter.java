package com.projeto.petshop.converter;

import com.projeto.petshop.dtos.UsuariosDto;
import com.projeto.petshop.models.Usuarios;

public class UsuariosConverter {
	
	public UsuariosConverter() {

	}

	public static UsuariosDto mapToDTO(final Usuarios users, final UsuariosDto usersDTO) {
		usersDTO.setDesCpf(users.getDesCpf());
		usersDTO.setDesNome(users.getDesNome());
		usersDTO.setDesSenha(users.getDesSenha());
		usersDTO.setIndTipo(users.getIndTipo());
		return usersDTO;
	}

	public static Usuarios mapToEntity(final UsuariosDto usersDTO, final Usuarios users) {
		users.setDesCpf(usersDTO.getDesCpf());
		users.setDesNome(usersDTO.getDesNome());
		users.setDesSenha(usersDTO.getDesSenha());
		users.setIndTipo(usersDTO.getIndTipo());
		return users;
	}

}
