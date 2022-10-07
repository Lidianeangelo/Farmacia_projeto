package com.farmacia.farmacia.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.farmacia.model.ProdutoModel;
import com.farmacia.farmacia.repository.ProdutoRepository;



@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>>getAll(){
		return ResponseEntity.ok(produtRepository.findAll());
	}
}
