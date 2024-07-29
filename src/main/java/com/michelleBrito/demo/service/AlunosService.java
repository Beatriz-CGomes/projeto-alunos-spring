package com.michelleBrito.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelleBrito.demo.model.Alunos;
import com.michelleBrito.demo.repository.AlunosRepository;

@Service
public class AlunosService {

	@Autowired
	private AlunosRepository alunosRepository;

	public List<Alunos> findAll() {
		return alunosRepository.findAll();
	}

	public Optional<Alunos> findById(Long id) {
		return alunosRepository.findById(id);
	}

	public List<Alunos> findByMatricula(BigDecimal matricula) {
		return alunosRepository.findByMatricula(matricula);
	}

	public List<Alunos> findByNome(String nome) {
		return alunosRepository.findByNomeContainsIgnoreCase(nome);
	}

	public Alunos postAluno(Alunos alunos) {
		return alunosRepository.save(alunos);
	}
	
	public void deleteAaluno(Long id) {
		alunosRepository.deleteById(id);
	}

}
