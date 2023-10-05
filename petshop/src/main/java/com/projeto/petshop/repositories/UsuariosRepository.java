package com.projeto.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.petshop.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String>{
	
//	@Query("select des_cpf from usuarios where des_cpf = :desCpf")
//	public boolean exist(String cpf);

}
