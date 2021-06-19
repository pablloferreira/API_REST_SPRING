package com.faculdadedelta.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faculdadedelta.produto.model.Produto;
import com.faculdadedelta.produto.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository pr;
	
	@GetMapping("/{id}")
	public Produto getProduto(@PathVariable(value = "id") int id) {
		Produto produto = pr.findById(id);
		return produto;
	}
	
	@GetMapping("/")
	public Iterable<Produto> getProdutos() {
		Iterable<Produto> produtos = pr.findAll();
		return produtos;
	}
	
	@GetMapping("/descricao/{descricao}")
	public Iterable<Produto> getProdutoDescricao(@PathVariable(value = "descricao") String descricao) {
		Iterable<Produto> produtos = pr.findByDescricao(descricao);
		return produtos;
	}
		
	@PostMapping("/")
	public void postProduto(@RequestBody Produto produto) {
		pr.save(produto);
	}
	
	@PutMapping("/")
	public void putProduto(@RequestBody Produto produto) {
		pr.save(produto);
	}
	
	@DeleteMapping("/")
	public void deleteProduto(@RequestBody Produto produto) {
		pr.delete(produto);
	}
	
	
}
