package com.faculdade.disciplinas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faculdade.disciplinas.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	@Query("SELECT obj FROM Disciplina obj JOIN FETCH obj.professores")
	List<Disciplina> buscaDisciplinaComCurso();
}
