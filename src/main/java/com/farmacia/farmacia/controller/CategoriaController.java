package com.farmacia.farmacia.controller;

import java.util.List;

import javax.validation.Valid;

import com.farmacia.farmacia.model.CategoriaModel;
import com.farmacia.farmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categRepository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(categRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable int id) {
		return categRepository.findById((long) id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<CategoriaModel>> getByTitle(@PathVariable String categoria) {
		return ResponseEntity.ok(categRepository.findAllByCategoriaContainingIgnoreCase(categoria));
	}

	@PostMapping
	public ResponseEntity<CategoriaModel> post(@Valid @RequestBody CategoriaModel categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categRepository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<CategoriaModel> put(@Valid @RequestBody CategoriaModel categoria) {
		return categRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(categRepository.save(categoria)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		java.util.Optional<CategoriaModel> categoria =categRepository.findById(id);
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		categRepository.deleteById(id);
	}
}