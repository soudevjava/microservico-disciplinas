package com.faculdade.disciplinas.controllers;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public List<CursoDTO>listarCursos(){
    	return service.listarCursos();
    }
    
    @DeleteMapping("{curso_id}")
    public ResponseEntity<Void> delete(@PathVariable long curso_id) {
    	service.deleteCurso(curso_id);
    	return ResponseEntity.noContent().build();
    }
}
