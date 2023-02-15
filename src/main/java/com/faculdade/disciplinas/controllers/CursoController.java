package com.faculdade.disciplinas.controllers;

import com.faculdade.disciplinas.dtos.CursoDTO;
import com.faculdade.disciplinas.entities.Curso;
import com.faculdade.disciplinas.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Curso> create(@RequestBody CursoDTO dto) {
        Curso novoCurso = cursoService.novoCurso(dto);

        return ResponseEntity.ok().body(novoCurso);
    }

}
