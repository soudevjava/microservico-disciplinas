package com.faculdade.disciplinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faculdade.disciplinas.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
