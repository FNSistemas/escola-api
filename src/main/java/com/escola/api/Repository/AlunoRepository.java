package com.escola.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Aluno;

@Repository
public interface AlunoRepository {
	
		public List<Aluno> findAll();
		
		public Aluno findBy(String nome);

}
