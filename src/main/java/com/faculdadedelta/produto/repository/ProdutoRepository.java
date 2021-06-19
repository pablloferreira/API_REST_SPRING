package com.faculdadedelta.produto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faculdadedelta.produto.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {
	
	Produto findById(int id);
		
	@Query("from Produto p WHERE p.descricao like %?1%")
	Iterable<Produto> findByDescricao(String descricao);
}
