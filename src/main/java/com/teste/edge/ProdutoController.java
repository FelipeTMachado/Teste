package com.teste.edge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.edge.services.ProdutoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repository;
	private ProdutoService service;
	
	@GetMapping("/produtos")
	public List<Produto> listaProduto(){
		return repository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> buscarPorCodigo(@PathVariable Long id) {
		Optional<Produto> obj = this.service.buscarID(id);
		
		if (obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		
		return ResponseEntity.ok(obj.get());
	}
	
	@PostMapping("/produtos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto salvaProduto(@RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	@PutMapping("/produtos/{produtoouid}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable Long produtoouid, @RequestBody Produto produto) {
		if (!repository.existsById(produtoouid)) {
			return ResponseEntity.badRequest().build();
		}
			
		produto.setCodigo(produtoouid);
		produto = repository.save(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Produto> excluirProduto(@PathVariable Long id) {
		Optional<Produto> obj = this.service.buscarID(id);
		
		if (obj.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}

