package com.escola.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.escola.api.model.Aluno;
import com.escola.api.model.Turma;
import com.escola.api.repository.TurmaRepository;

@RestController
@RequestMapping(value = "/turmas")

public class TurmaController {

       @PostMapping
       private  ResponseEntity<Turma> cadastrarTurma(@RequestBody Turma turma){
            return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
       }

       @GetMapping
       public ResponseEntity<List<Turma>> listarTurmas() {
	  	return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.findAll());
       }
   
       @GetMapping("/{id}")
	  public ResponseEntity<Optional<Turma>> obterTurmaPeloID(@PathVariable("id") long id)  {
        Optional<Turma> optionaTurma = turmaRepository.findById((id));

        if (optionaTurma.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//
        }  

        return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.findById(id));

        }

        @GetMapping("/nome{nome}")
        public ResponseEntity<Optional<Turma>> obterTurmaPeloNome(@PathVariable("nome") String nome)  {
           Optional<Turma> optionaTurma = turmaRepository.findByNome((nome));
   
           if (optionaTurma.isEmpty()) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//
           }  
   
           return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.findByNome(nome));//
        }


	
   
       @PutMapping("/{id}")
       public ResponseEntity<Turma> atualizarTurma(@PathVariable("id") long id, @RequestBody Turma turma){
          Optional<Turma> optionaTurma = turmaRepository.findById((id));

        if (optionaTurma.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//
        }
        
        Turma turmaExistente = optionaTurma.get();

        turmaExistente.setNome((turma.getNome()));
        turmaExistente.setCargaHoraria((turma.getCargaHoraria()));
        turmaExistente.setDataInicio((turma.getDataInicio()));
        turmaExistente.setDataTermino((turma.getDataTermino()));

        return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.save(turmaExistente));

     }    



       @Autowired
       private TurmaRepository turmaRepository;

}
