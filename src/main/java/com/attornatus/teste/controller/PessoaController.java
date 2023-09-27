package com.attornatus.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.teste.model.Pessoa;
import com.attornatus.teste.repository.PessoaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Pessoa>> getAll(){
		return ResponseEntity.ok(pessoaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Long id){
		return pessoaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> post(@Valid @RequestBody Pessoa pessoa){
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRepository.save(pessoa));
	}
	
	@PutMapping
    public ResponseEntity<Pessoa> put(@Valid @RequestBody Pessoa pessoa){
        return pessoaRepository.findById(pessoa.getId())
        		.map(resp -> ResponseEntity.status(HttpStatus.CREATED)
        				.body(pessoaRepository.save(pessoa)))
        		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
