package com.faculdade.disciplinas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faculdade.disciplinas.dtos.CursoDTO;
import com.faculdade.disciplinas.entities.Curso;
import com.faculdade.disciplinas.enums.Status;
import com.faculdade.disciplinas.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	@Transactional
	public CursoDTO editCurso(long curso_id, CursoDTO dto) {
		Curso dados = repository.getReferenceById(curso_id);
		//dados = new Curso(Status.valueOf(dto.getStatus()), curso_id);
		if(dto.getStatus()!= null ) {
			dados.setStatus(Status.valueOf(dto.getStatus()));
		}
		if (dto.getDataTermino() != null) {
			dados.setDataTermino(dto.getDataTermino());
		}
		if(dto.getPeriodo() != null) {
			dados.setPeriodo(dto.getPeriodo());
		}
				
		return new CursoDTO(repository.save(dados));
	}
		
    public CursoDTO novoCurso(CursoDTO dto) {
        Curso novoCurso = new Curso(dto);
        return new CursoDTO(repository.save(novoCurso));
    }

	@Transactional(readOnly = true)
	public List<CursoDTO> listarCursos() {
		List<Curso> list = repository.findAll();
		return list.stream().map((x) -> new CursoDTO(x)).toList();
	}
}
