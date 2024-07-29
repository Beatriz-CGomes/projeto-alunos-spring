package com.michelleBrito.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("{id}")
	public ResponseEntity<Cursos> findById(@PathVariable Long id) {
		Optional<Cursos> encontrarIdCurso = cursosService.findById(id);

		if (encontrarIdCurso.isPresent()) {
			return ResponseEntity.ok(encontrarIdCurso.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Cursos> postCurso(@RequestBody Cursos cursos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cursosService.postCursos(cursos));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
		Optional<Cursos> deleteByIdCurso = cursosService.findById(id);

		if (deleteByIdCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			cursosService.delete(id);
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cursos> putCurso(@RequestBody Cursos cursos, @PathVariable Long id) {
		Cursos updateCursos = cursosService.putCursos(cursos, id);

		if (updateCursos != null) {
			return ResponseEntity.ok().body(updateCursos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
