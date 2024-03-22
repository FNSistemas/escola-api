package com.escola.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.escola.api.model.Aluno;
import com.escola.api.repository.AlunoRepository;

@RestController
@RequestMapping(value = "/alunos")

public class AlunoController {

  
    @PostMapping
    private  ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }

    @GetMapping
	public ResponseEntity<List<Aluno>> listarAlunos() {
		return ResponseEntity.status(HttpStatus.OK).body(AlunoRepository.findall());
	}
   


    

    @Autowired
    private AlunoRepository alunoRepository;


}
