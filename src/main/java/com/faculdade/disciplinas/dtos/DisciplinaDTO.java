package com.faculdade.disciplinas.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.faculdade.disciplinas.entities.Disciplina;

public class DisciplinaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long disciplina_id;
	private String nome;
	private Double valor;
	private String status;

	private Set<ProfessorMinDTO> professores = new HashSet<>();

	public DisciplinaDTO() {
	}

	public DisciplinaDTO(Long disciplina_id, String nome, Double valor, String status) {
		super();
		this.disciplina_id = disciplina_id;
		this.nome = nome;
		this.valor = valor;
		this.status = status;
	}

	public DisciplinaDTO(Disciplina entity) {
		super();
		this.disciplina_id = entity.getDisciplina_id();
		this.nome = entity.getNome();
		this.valor = entity.getValor();
		this.status = entity.getStatus();

		entity.getProfessores().forEach(x -> this.professores.add(new ProfessorMinDTO(x)));
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
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<ProfessorMinDTO> getProfessores() {
		return professores;
	}

}
