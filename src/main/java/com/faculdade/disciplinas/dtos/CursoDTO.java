package com.faculdade.disciplinas.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.faculdade.disciplinas.entities.Curso;
import com.faculdade.disciplinas.enums.Status;

public class CursoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long curso_id;
	private String nome;
	private LocalDate dataTermino;
	private Status status;
	private Integer periodo;
	
	private Set<DisciplinaDTO> disciplinas = new HashSet<>();

	public CursoDTO() {
	}
	
	public CursoDTO(Long curso_id, String nome, LocalDate dataTermino, Status status, Integer periodo) {
		this.curso_id = curso_id;
		this.nome = nome;
		this.dataTermino = dataTermino;
		this.status = status;
		this.periodo = periodo;
	}

	public CursoDTO(Curso entity) {
		curso_id = entity.getCurso_id();
		nome = entity.getNome();
		dataTermino = entity.getDataTermino();
		status = Status.valueOf(entity.getStatus());
		periodo = entity.getPeriodo();
		
		entity.getDisciplinas().forEach(x -> this.disciplinas.add(new DisciplinaDTO(x)));
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
		if(status == null)
			return null;
		else
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

	public Set<DisciplinaDTO> getDisciplinas() {
		return disciplinas;
	}
	
}
