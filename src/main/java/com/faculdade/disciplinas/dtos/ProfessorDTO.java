package com.faculdade.disciplinas.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.faculdade.disciplinas.entities.Professor;

public class ProfessorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long professor_id;
	private String nome;
	private String cpf;
	private LocalDate dataNasci;
	private String email;
	private String rg;
		
	private Set<DisciplinaDTO> disciplinas = new HashSet<>();
	
	public ProfessorDTO() {
	}

	public ProfessorDTO(Long professor_id, String nome, String cpf, LocalDate dataNasci, String email, String rg) {
		this.professor_id = professor_id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasci = dataNasci;
		this.email = email;
		this.rg = rg;
	}
	
	public ProfessorDTO(Professor entity) {
		professor_id = entity.getProfessor_id();
		nome = entity.getNome();
		cpf = entity.getNome();
		dataNasci = entity.getDataNasci();
		email = entity.getEmail();
		rg = entity.getRg();
		
		//disciplinas.addAll(entity.getDisciplinas().stream().map(x -> new DisciplinaDTO(x, x.getProfessores())).toList());
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

	public Set<DisciplinaDTO> getDisciplinas() {
		return disciplinas;
	}
	
}
