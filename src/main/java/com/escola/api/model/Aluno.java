package com.escola.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Aluno {
        
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long idAluno;

     @Column(nullable = false, length = 50)
     private String nome;

     @Column(nullable = false, length = 150)
     private String sobreNome;
     
     @Column(nullable = false, unique = true)
     private String email;

     @JsonFormat(pattern = "dd/MM/yyyy")
     private LocalDate dataNascimento;
 
}
    




