package com.faculdade.disciplinas.services;

import com.faculdade.disciplinas.dtos.CursoDTO;
import com.faculdade.disciplinas.entities.Curso;

public interface CursoService {
    Curso novoCurso(CursoDTO curso);
}
