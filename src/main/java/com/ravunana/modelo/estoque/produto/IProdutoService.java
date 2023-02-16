package com.ravunana.modelo.estoque.produto;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProdutoService {
    void createProduto(ProdutoDto produtoDto);
    List<Produto> findAllProdutos();
    Optional<Produto> showProduto(Integer id);
    String exportReport(String format) throws FileNotFoundException, JRException;
    Produto produtoExpirado(Produto produto);
    void updateProduto(Integer id);
    void deleteProduto(Integer id);
}
