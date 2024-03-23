package com.escola.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Aluno;
import com.escola.api.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma,Long>{

    Optional<Turma> findByNome(String nome);

}
