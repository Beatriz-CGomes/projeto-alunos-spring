package com.michelleBrito.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.michelleBrito.demo.model.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long>{

	public List<Cursos> findByNomeCursoContainsIgnoreCase(@Param("nomeCurso") String nomeCurso);
	
}
