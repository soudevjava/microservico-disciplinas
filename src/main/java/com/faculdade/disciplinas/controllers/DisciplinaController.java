package com.faculdade.disciplinas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.faculdade.disciplinas.dtos.DisciplinaDTO;
import com.faculdade.disciplinas.dtos.DisciplinaMinDTO;
import com.faculdade.disciplinas.services.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;
	
	@GetMapping
	public List<DisciplinaMinDTO> buscarDisciplinas(){
		return service.buscarDisciplinas();
	}
	
	@GetMapping("/professores")
	public List<DisciplinaDTO> buscarDisciplinaComProfessores(){
		return service.buscarDisciplinaComProfessores();
	}
	
	@PostMapping
	public ResponseEntity<DisciplinaDTO> cadastrarDisciplina(@RequestBody DisciplinaDTO dto){
		DisciplinaDTO newDto = service.cadastrarDisciplina(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getDisciplina_id()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
}
