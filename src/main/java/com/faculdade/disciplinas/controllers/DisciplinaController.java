package com.faculdade.disciplinas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
