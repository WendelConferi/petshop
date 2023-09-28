package com.projeto.petshop.dtos;

import com.projeto.petshop.models.Usuarios;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuariosDto {

	@NotBlank
	private String desCpf;
	@NotBlank
	private String desNome;
	@NotBlank
	private String desSenha;
	@NotBlank
	private Integer indTipo;


}
