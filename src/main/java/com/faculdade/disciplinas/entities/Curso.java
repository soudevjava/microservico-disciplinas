package com.faculdade.disciplinas.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.faculdade.disciplinas.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long curso_id;
	
	@Column(length = 50)
	private String nome;
	
	private LocalDate dataTermino;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	private Integer periodo;
	
	@ManyToMany
	@JoinTable(name = "lista_disciplina",
		joinColumns = @JoinColumn(name = "disciplina_id"),
		inverseJoinColumns = @JoinColumn(name = "curso_id"))
	private Set<Disciplina> disciplinas = new HashSet<>();
		
	public Curso() {}

	public Curso(Long curso_id, String nome, Status status, Integer periodo) {
		this.curso_id = curso_id;
		this.nome = nome;
		this.status = status;
		this.periodo = periodo;
	}

	public Long getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(Long curso_id) {
		this.curso_id = curso_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getStatus() {
		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}
