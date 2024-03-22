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

@Entity(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long idUsuario;

     @Column(nullable = false, length = 20)
     private String nome;

     @Column(nullable = false, length = 100)
     private String email;

}
