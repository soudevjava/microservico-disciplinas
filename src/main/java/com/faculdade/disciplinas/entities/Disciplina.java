package com.faculdade.disciplinas.entities;

import java.util.HashSet;
import java.util.Set;

import com.faculdade.disciplinas.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long disciplina_id;
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 10, scale = 2)
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToMany(mappedBy = "disciplinas")
	private Set<Curso> cursos = new HashSet<>();
	
	@ManyToMany(mappedBy = "disciplinas")
	private Set<Professor> professores = new HashSet<>();
	
	public Disciplina() {}

	public Disciplina(Long disciplina_id, String nome, Double valor, Status status) {
		this.disciplina_id = disciplina_id;
		this.nome = nome;
		this.valor = valor;
		this.status = status;
	}

	public Long getDisciplina_id() {
		return disciplina_id;
	}

	public void setDisciplina_id(Long disciplina_id) {
		this.disciplina_id = disciplina_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}
}
