package com.ravunana.modelo.estoque.produto;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ProdutoRepository {

    Optional<Produto> findById(Integer id);
    List<Produto> findAllProdutos();
    void save(Produto produto);
    void delete(Produto produto);
    boolean existsByNome(String nome);

}
