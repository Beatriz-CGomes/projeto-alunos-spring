package com.michelleBrito.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelleBrito.demo.model.Cursos;
import com.michelleBrito.demo.service.CursosService;

@RestController
@RequestMapping(value = "/cursos")
public class CursosController {

	@Autowired
	private CursosService cursosService;

	@GetMapping
	public ResponseEntity<List<Cursos>> findAll() {
		return ResponseEntity.ok(cursosService.findAll());
	}
	
	
	
}
