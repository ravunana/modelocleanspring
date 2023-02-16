package com.ravunana.modelo.estoque.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;
    private Double preco;
    private Integer quantidade;
    private String categoria;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Column(name = "data_expiracao")
    private LocalDate dataExpiracao;

    public Produto() {
    }

    public Produto(String nome, Double preco, Integer quantidade, String categoria, LocalDate dataExpiracao) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.dataCriacao = LocalDate.now();
        this.dataExpiracao = dataExpiracao;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", categoria='" + categoria + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataExpiracao=" + dataExpiracao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (!Objects.equals(id, produto.id)) return false;
        if (!Objects.equals(nome, produto.nome)) return false;
        if (!Objects.equals(preco, produto.preco)) return false;
        if (!Objects.equals(quantidade, produto.quantidade)) return false;
        if (!Objects.equals(categoria, produto.categoria)) return false;
        if (!Objects.equals(dataCriacao, produto.dataCriacao)) return false;
        return Objects.equals(dataExpiracao, produto.dataExpiracao);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (dataExpiracao != null ? dataExpiracao.hashCode() : 0);
        return result;
    }
}
