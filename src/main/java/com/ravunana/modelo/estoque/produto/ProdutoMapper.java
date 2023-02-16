package com.ravunana.modelo.estoque.produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {

    public Produto toEntity(ProdutoDto produtoDto){
        final Produto produto = new Produto(produtoDto.nome, produtoDto.preco, produtoDto.quantidade, produtoDto.categoria, produtoDto.dataExpiracao);
        produto.setDataCriacao( LocalDate.now() );
        return produto;
    }

    public ProdutoDto toDto(Produto produto){
        final ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.nome = produto.getNome();
        produtoDto.preco = produto.getPreco();
        produtoDto.categoria = produto.getCategoria();
        produtoDto.quantidade = produto.getQuantidade();
        produtoDto.dataExpiracao = produto.getDataExpiracao();

        return produtoDto;
    }


    public List<ProdutoDto> toProdutoDtoList(List<Produto> produtoList){
        List<ProdutoDto> list = new ArrayList<>();

        for (var produto: produtoList){
            var produtoDto = new ProdutoDto();

            produtoDto.nome = produto.getNome();
            produtoDto.preco = produto.getPreco();
            produtoDto.quantidade = produto.getQuantidade();
            produtoDto.categoria = produto.getCategoria();
            produtoDto.dataExpiracao = produto.getDataExpiracao();

            list.add(produtoDto);
        }

        return list;
    }
}
