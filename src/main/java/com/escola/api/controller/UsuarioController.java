package com.escola.api.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.escola.api.model.Usuario;
import com.escola.api.repository.TurmaRepository;
import com.escola.api.repository.UsuarioRepository;


import com.escola.api.model.Usuario;
import com.escola.api.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")

public class UsuarioController {

       @PostMapping
       private  ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
       }

       @Autowired
       private UsuarioRepository usuarioRepository;


}
