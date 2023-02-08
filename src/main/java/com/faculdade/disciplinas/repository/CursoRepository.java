package com.faculdade.disciplinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faculdade.disciplinas.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
