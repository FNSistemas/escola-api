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

@Entity(name = "turmas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Turma {

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long idTurma;

     @Column(nullable = false, length = 50)
     private String nome;

     @Column(nullable = false)
     private Integer cargaHoraria;
          
     @JsonFormat(pattern = "dd/MM/yyyy")
     private LocalDate dataInicio;
 
     @JsonFormat(pattern = "dd/MM/yyyy")
     private LocalDate dataTermino;
 
}
