package com.escola.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.model.Aluno;

public class AlunoService {
	
	@Autowired
	private JpaRepository rep;
	
	public List<Aluno> consultaTodos() {
		return rep.findAll();
	}

}
