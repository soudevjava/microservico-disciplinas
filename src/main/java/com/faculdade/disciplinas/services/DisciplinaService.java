package com.faculdade.disciplinas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faculdade.disciplinas.dtos.DisciplinaDTO;
import com.faculdade.disciplinas.entities.Disciplina;
import com.faculdade.disciplinas.repositories.DisciplinaRepository;
import com.faculdade.disciplinas.service.exception.RecursoNaoLocalizado;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	@Transactional(readOnly = true)
	public List<DisciplinaDTO> buscarDisciplinaComProfessores() {
		List<Disciplina> objs = repository.findAll();
		if(objs.isEmpty()) {
			throw new RecursoNaoLocalizado("Nenhuma disciplina registrada");
		}
		return objs.stream().map(x -> new DisciplinaDTO(x)).toList();
	}

}
