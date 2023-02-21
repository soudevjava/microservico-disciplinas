package com.faculdade.disciplinas.dtos;

import java.io.Serializable;

import com.faculdade.disciplinas.entities.Disciplina;

public class DisciplinaMinDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long disciplina_id;
	private String nome;
	private Double valor;
	private String status;

	public DisciplinaMinDTO() {
	}

	public DisciplinaMinDTO(Long disciplina_id, String nome, Double valor, String status) {
		super();
		this.disciplina_id = disciplina_id;
		this.nome = nome;
		this.valor = valor;
		this.status = status;
	}

	public DisciplinaMinDTO(Disciplina entity) {
		super();
		this.disciplina_id = entity.getDisciplina_id();
		this.nome = entity.getNome();
		this.valor = entity.getValor();
		this.status = entity.getStatus();
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

}
