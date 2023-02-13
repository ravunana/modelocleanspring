package com.ravunana.modelo.core.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteJPARepository extends JpaRepository<Cliente, String> {
}
