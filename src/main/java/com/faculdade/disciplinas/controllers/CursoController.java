package com.faculdade.disciplinas.controllers;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.faculdade.disciplinas.dtos.CursoDTO;
import com.faculdade.disciplinas.services.CursoService;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public CursoDTO create(@RequestBody CursoDTO dto) {
    	return service.novoCurso(dto);
    }
    
    @PutMapping("{curso_id}")
    public CursoDTO editCurso(@PathVariable long curso_id, @RequestBody CursoDTO dto ) {
    	return service.editCurso(curso_id, dto);
    }

}
