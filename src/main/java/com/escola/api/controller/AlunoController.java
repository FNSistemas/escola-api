package com.escola.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.jaxb.internal.MappingBinder.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.escola.api.model.Aluno;
import com.escola.api.repository.AlunoRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/alunos")

public class AlunoController {

  
    @PostMapping
    private  ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }

    @GetMapping
	public ResponseEntity<List<Aluno>> listarAlunos() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
	}
   

    @GetMapping("/{id}")
	public ResponseEntity<Optional<Aluno>> obterAlunoPeloID(@PathVariable("id") long id)  {
        Optional<Aluno> optionaAluno = alunoRepository.findById((id));

        if (optionaAluno.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//
        }  

        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findById(id));//
	}
   
    @GetMapping("/email{email}")
	public ResponseEntity<Optional<Aluno>> obterAlunoPeloEmail(@PathVariable("email") String email)  {
        Optional<Aluno> optionaAluno = alunoRepository.findByEmail((email));

        if (optionaAluno.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//
        }  

        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findByEmail(email));//
	}
   

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable("id") long id, @RequestBody Aluno aluno){
        Optional<Aluno> optionaAluno = alunoRepository.findById((id));

        if (optionaAluno.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//
        }
        
        Aluno alunoExistente = optionaAluno.get();

        alunoExistente.setNome((aluno.getNome()));
        alunoExistente.setSobreNome((aluno.getSobreNome()));
        alunoExistente.setEmail((aluno.getEmail()));
        alunoExistente.setDataNascimento((aluno.getDataNascimento()));

        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoExistente));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable("id") long id){
       Optional<Aluno> optionaAluno = alunoRepository.findById((id));

       if (optionaAluno.isEmpty()) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//
       }

       alunoRepository.deleteById(id);

       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Autowired
    private AlunoRepository alunoRepository;


}
