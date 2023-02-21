package com.faculdade.disciplinas.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.faculdade.disciplinas.entities.Professor;

public class ProfessorMinDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long professor_id;
	private String nome;
	private String email;
	
	public ProfessorMinDTO() {
	}

	public ProfessorMinDTO(Long professor_id, String nome, String cpf, LocalDate dataNasci, String email, String rg) {
		this.professor_id = professor_id;
		this.nome = nome;
		this.email = email;
	}
	
	public ProfessorMinDTO(Professor entity) {
		professor_id = entity.getProfessor_id();
		nome = entity.getNome();
		email = entity.getEmail();
	}

	public Long getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
