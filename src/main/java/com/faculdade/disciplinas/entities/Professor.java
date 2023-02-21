package com.faculdade.disciplinas.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.faculdade.disciplinas.dtos.ProfessorMinDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long professor_id;

	@Column(length = 50)
	private String nome;

	@Column(length = 11)
	private String cpf;

	private LocalDate dataNasci;

	@Column(length = 70)
	private String email;

	@Column(length = 11)
	private String rg;

	@ManyToMany(mappedBy = "professores")
	private Set<Disciplina> disciplinas = new HashSet<>();

	public Professor() {
	}
	
	public Professor(ProfessorMinDTO entity) {
		this.professor_id = entity.getProfessor_id();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(LocalDate dataNasci) {
		this.dataNasci = dataNasci;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}
