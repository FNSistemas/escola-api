package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Turma;
import com.escola.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
}
