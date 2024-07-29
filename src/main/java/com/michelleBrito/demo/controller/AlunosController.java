package com.michelleBrito.demo.controller;

import java.math.BigDecimal;
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

import com.michelleBrito.demo.model.Alunos;
import com.michelleBrito.demo.repository.AlunosRepository;
import com.michelleBrito.demo.repository.CursosRepository;
import com.michelleBrito.demo.service.AlunosService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunosController {

	@Autowired
	private AlunosService alunoService;

	@Autowired
	private CursosRepository cursosRepository;

	@Autowired
	private AlunosRepository alunosRepository;

	@GetMapping()
	public ResponseEntity<List<Alunos>> findAll() {
		return ResponseEntity.ok(alunoService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Alunos> findById(@PathVariable Long id) {
		Optional<Alunos> encontrarId = alunoService.findById(id);

		if (encontrarId.isPresent()) {
			return ResponseEntity.ok().body(encontrarId.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("matricula/{matricula}")
	public ResponseEntity<List<Alunos>> findByMatricula(@PathVariable BigDecimal matricula) {
		List<Alunos> encontrarMatricula = alunoService.findByMatricula(matricula);

		if (encontrarMatricula.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok().body(encontrarMatricula);
		}
	}

	@GetMapping("nomes/{nome}")
	public ResponseEntity<List<Alunos>> findByNome(@PathVariable String nome) {
		List<Alunos> encontrarNome = alunoService.findByNome(nome);

		if (encontrarNome.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(encontrarNome);
		}
	}

	@PostMapping
	public ResponseEntity<Alunos> post(@RequestBody Alunos alunos) {
		if (cursosRepository.existsById(alunos.getCursos().getId())) {
			return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.postAluno(alunos));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Optional<Alunos> deleteAlunoId = alunoService.findById(id);

		if (deleteAlunoId.isPresent()) {
			alunoService.deleteAaluno(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Alunos> putAlunos(@RequestBody Alunos alunos, @PathVariable Long id) {
		Alunos alunosUpdate = alunoService.putAluno(id, alunos);

		if (alunosRepository.existsById(alunos.getId())) {
			if (cursosRepository.existsById(alunos.getCursos().getId())) {
				return ResponseEntity.ok().body(alunosUpdate);
			}
		}

		return ResponseEntity.notFound().build();
	}

}
