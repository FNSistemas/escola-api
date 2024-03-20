package com.escola.api.model;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

import jakarta.persistence.Entity;
@Entity
public class Aluno {
	
	public long idAluno;
	public String nome;
	public String sobreNome;
	public String email;
	public LocalDate dataNascimento;

	public long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idAluno);
	}
	

}
