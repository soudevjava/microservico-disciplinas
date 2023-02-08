package com.faculdade.disciplinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faculdade.disciplinas.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
