package com.faculdade.disciplinas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faculdade.disciplinas.dtos.DisciplinaDTO;
import com.faculdade.disciplinas.dtos.DisciplinaMinDTO;
import com.faculdade.disciplinas.dtos.ProfessorMinDTO;
import com.faculdade.disciplinas.entities.Disciplina;
import com.faculdade.disciplinas.entities.Professor;
import com.faculdade.disciplinas.enums.Status;
import com.faculdade.disciplinas.repositories.DisciplinaRepository;
import com.faculdade.disciplinas.repositories.ProfessorRepository;
import com.faculdade.disciplinas.service.exception.RecursoNaoLocalizado;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Transactional(readOnly = true)
	public List<DisciplinaMinDTO> buscarDisciplinas() {
		List<DisciplinaMinDTO> dtos = repository.buscarTodas();
		if(dtos.isEmpty()) {
			throw new RecursoNaoLocalizado("Nenhuma disciplina registrada");
		}
		return dtos;
	}
	
	@Transactional(readOnly = true)
	public List<DisciplinaDTO> buscarDisciplinaComProfessores() {
		List<Disciplina> objs = repository.findAll();
		if(objs.isEmpty()) {
			throw new RecursoNaoLocalizado("Nenhuma disciplina registrada");
		}
		return objs.stream().map(x -> new DisciplinaDTO(x)).toList();
	}

	@Transactional
	public DisciplinaDTO cadastrarDisciplina(DisciplinaDTO dto) {
		
		Disciplina obj = new Disciplina();
		obj.setNome(dto.getNome());
		obj.setValor(dto.getValor());
		obj.setStatus(Status.valueOf(dto.getStatus()));
		
		for (ProfessorMinDTO profDto : dto.getProfessores()) {
			Professor professor = professorRepository.getReferenceById(profDto.getProfessor_id());
			obj.getProfessores().add(professor);
		}
		obj = repository.save(obj);
		
		return new DisciplinaDTO(obj);
	}

}
