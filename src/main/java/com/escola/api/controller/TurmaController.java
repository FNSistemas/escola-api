package com.escola.api.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.escola.api.model.Turma;
import com.escola.api.repository.TurmaRepository;

@RestController
@RequestMapping(value = "/turmas")

public class TurmaController {

       @PostMapping
       private  ResponseEntity<Turma> cadastrarTurma(@RequestBody Turma turma){
            return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
       }

       @Autowired
       private TurmaRepository turmaRepository;

}
