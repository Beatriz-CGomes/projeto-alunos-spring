package com.michelleBrito.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_alunos")
public class Alunos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	private String email;

	private BigDecimal matricula;


	//associação de tabelas
	@ManyToOne
	@JsonIgnoreProperties("alunos")
	private Cursos cursos;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getMatricula() {
		return matricula;
	}

	public void setMatricula(BigDecimal matricula) {
		this.matricula = matricula;
	}
	
	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}
}
