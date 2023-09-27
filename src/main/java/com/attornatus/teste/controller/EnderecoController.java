package com.attornatus.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.teste.model.Endereco;
import com.attornatus.teste.repository.EnderecoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		return ResponseEntity.ok(enderecoRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Endereco> post(@Valid @RequestBody Endereco endereco){
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
	}

}
