package com.projeto.petshop.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
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
