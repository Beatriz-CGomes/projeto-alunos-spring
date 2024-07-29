package com.michelleBrito.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.michelleBrito.demo.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {

	public List<Alunos> findByMatricula(BigDecimal matricula);

	public List<Alunos> findByNomeContainsIgnoreCase(@Param("nome") String nome);

}
