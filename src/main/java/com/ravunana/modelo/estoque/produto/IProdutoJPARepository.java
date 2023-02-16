package com.ravunana.modelo.estoque.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoJPARepository extends JpaRepository<Produto, Integer> {
}
