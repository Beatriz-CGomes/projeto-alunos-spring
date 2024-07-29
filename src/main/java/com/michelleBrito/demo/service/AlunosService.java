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

	
	//LISTA DE ALUNOS
	public List<Alunos> findAll() {
		return alunosRepository.findAll();
	}

	//ALUNOS POR ID
	public Optional<Alunos> findById(Long id) {
		return alunosRepository.findById(id);
	}

	//ALUNOS POR MATRICULA
	public List<Alunos> findByMatricula(BigDecimal matricula) {
		return alunosRepository.findByMatricula(matricula);
	}

	//ALUNOS POR NOME
	public List<Alunos> findByNome(String nome) {
		return alunosRepository.findByNomeContainsIgnoreCase(nome);
	}

	//POST DE ALUNOS
	public Alunos postAluno(Alunos alunos) {
		return alunosRepository.save(alunos);
	}
	
	//DELETE ALUNO POR ID
	public void deleteAaluno(Long id) {
		alunosRepository.deleteById(id);
	}

	//ALTERACAO DE ALUNO POR ID
	public Alunos putAluno(Long id, Alunos alunos) {
		Alunos alunosUpdate = alunosRepository.findById(id).orElse(null);
		
		if(alunosUpdate != null) {
			putUpdateAlunos(alunos, alunosUpdate);
			return alunosRepository.save(alunosUpdate);
		} else {
			return null;
		}
	}
	
	
	public void putUpdateAlunos(Alunos alunosCadastrados, Alunos alunosUpdate) {
		alunosUpdate.setNome(alunosCadastrados.getNome());
		alunosUpdate.setEmail(alunosCadastrados.getEmail());
		alunosUpdate.setMatricula(alunosCadastrados.getMatricula());
	}
}
