package com.faculdade.disciplinas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faculdade.disciplinas.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	@Query("SELECT obj FROM Curso obj JOIN FETCH obj.disciplinas")
    List<Curso> buscaCursoComDisciplina();
}
