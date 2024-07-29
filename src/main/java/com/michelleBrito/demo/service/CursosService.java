package com.michelleBrito.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelleBrito.demo.model.Cursos;
import com.michelleBrito.demo.repository.CursosRepository;

@Service
public class CursosService {

	@Autowired
	private CursosRepository cursosRepository;

	public List<Cursos> findAll() {
		return cursosRepository.findAll();
	}

	public Optional<Cursos> findById(Long id) {
		return cursosRepository.findById(id);
	}

	public List<Cursos> findByNomeCurso(String nomeCursos) {
		return cursosRepository.findByNomeCursoContainsIgnoreCase(nomeCursos);
	}

	public Cursos postCursos(Cursos cursos) {
		return cursosRepository.save(cursos);
	}
	
	public void delete(Long id) {
		cursosRepository.deleteById(id);
	}
}
