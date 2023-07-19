package com.projeto.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.petshop.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String>{

}
