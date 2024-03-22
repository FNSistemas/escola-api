package com.escola.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Aluno;
import java.util.List;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long>{

    Optional<Aluno> findByEmail(String email);
}


