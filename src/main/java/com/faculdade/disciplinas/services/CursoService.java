package com.faculdade.disciplinas.services;

import com.faculdade.disciplinas.dtos.CursoDTO;
import com.faculdade.disciplinas.entities.Curso;
import com.faculdade.disciplinas.enums.Status;
import com.faculdade.disciplinas.repositories.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService{
    private final CursoRepository cursoRepository;

    public Curso novoCurso(CursoDTO curso) {
        Curso novoCurso = new Curso();
        novoCurso.setNome(curso.getNome());
        novoCurso.setPeriodo(curso.getPeriodo());
        novoCurso.setDataTermino(curso.getDataTermino());
        novoCurso.setStatus(Status.valueOf(curso.getStatus()));
        cursoRepository.save(novoCurso);

        return novoCurso;
    }
}
