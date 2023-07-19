package com.projeto.petshop.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "des_cpf", nullable = false, unique = true)
	private String desCpf;

	@Column(name = "des_nome", nullable = false)
	private String desNome;

	@Column(name = "ind_tipo", nullable = false, unique = true)
	private Integer indTipo;

	@Column(name = "des_senha", nullable = false)
	private String desSenha;

}

