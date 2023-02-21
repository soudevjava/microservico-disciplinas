package com.faculdade.disciplinas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faculdade.disciplinas.dtos.DisciplinaMinDTO;
import com.faculdade.disciplinas.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	@Query("SELECT new com.faculdade.disciplinas.dtos.DisciplinaMinDTO(obj) FROM Disciplina obj")
	List<DisciplinaMinDTO> buscarTodas();
	
}
