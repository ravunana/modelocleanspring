package com.ravunana.modelo.estoque.produto;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
public class ProdutoSQLRepository implements ProdutoRepository{

    private final IProdutoJPARepository iProdutoJPARepository;

    public ProdutoSQLRepository(IProdutoJPARepository iProdutoJPARepository) {
        this.iProdutoJPARepository = iProdutoJPARepository;
    }

    @Override
    public Optional<Produto> findById(Integer id) {
        return iProdutoJPARepository.findById(id);
    }

    @Override
    public List<Produto> findAllProdutos() {
        return iProdutoJPARepository.findAll();
    }

    @Override
    public void save(Produto produto) {
        iProdutoJPARepository.save(produto);
    }

    @Override
    public void delete(Produto produto) {
        iProdutoJPARepository.delete(produto);
    }

    @Override
    public boolean existsByNome(String nome) {
        return false;
    }

}
