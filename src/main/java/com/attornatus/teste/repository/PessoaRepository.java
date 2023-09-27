package com.attornatus.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.teste.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	
}
