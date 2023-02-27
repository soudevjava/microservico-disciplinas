package com.faculdade.disciplinas.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoLocalizado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RecursoNaoLocalizado(String msg) {
		super(msg);
	}

}
