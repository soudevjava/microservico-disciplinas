package com.faculdade.disciplinas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faculdade.disciplinas.dtos.CursoDTO;
import com.faculdade.disciplinas.entities.Curso;
import com.faculdade.disciplinas.repositories.CursoRepository;

@Service
public class CursoService{
    
	@Autowired
	private CursoRepository repository;

	@Transactional(readOnly = true)
    public CursoDTO novoCurso(CursoDTO dto) {
        Curso novoCurso = new Curso(dto);
        return new CursoDTO(repository.save(novoCurso));
    }
}
