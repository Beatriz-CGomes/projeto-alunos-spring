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

	// LISTA DE CURSOS
	public List<Cursos> findAll() {
		return cursosRepository.findAll();
	}

	// CURSOS POR ID
	public Optional<Cursos> findById(Long id) {
		return cursosRepository.findById(id);
	}

	// CURSOS POR NOME
	public List<Cursos> findByNomeCurso(String nomeCursos) {
		return cursosRepository.findByNomeCursoContainsIgnoreCase(nomeCursos);
	}

	// POST DE CURSOS
	public Cursos postCursos(Cursos cursos) {
		return cursosRepository.save(cursos);
	}

	// DELETE CURSO POR ID
	public void delete(Long id) {
		cursosRepository.deleteById(id);
	}

	// ALTERACAO DE CURSO POR ID
	public Cursos putCursos(Cursos curso, Long id) {
		Cursos cursosUpdate = cursosRepository.findById(id).orElse(null);

		if (cursosUpdate != null) {
			updateCursos(curso, cursosUpdate);
			return cursosRepository.save(cursosUpdate);
		} else {
			return null;
		}
	}

	public void updateCursos(Cursos cursosCadastrados, Cursos cursosUpdate) {
		cursosUpdate.setNomeCurso(cursosCadastrados.getNomeCurso());
		cursosUpdate.setDescricaoCurso(cursosCadastrados.getDescricaoCurso());
		cursosUpdate.setDuracao(cursosCadastrados.getDuracao());
	}

}
