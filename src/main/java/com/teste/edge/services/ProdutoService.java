package com.teste.edge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.edge.Produto;
import com.teste.edge.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Optional<Produto> buscarID(Long id) {
		return repository.findById(id);

	}
	
	
}
