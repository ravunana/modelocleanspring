package com.ravunana.modelo.core.cliente;

import com.ravunana.modelo.core.cliente.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    Optional<Cliente> findByID(String id);
    List<Cliente> findAllClientes();
    void save(Cliente cliente);
    void delete(Cliente cliente);
    boolean existsByEmail(String email);
    boolean existsByNif(String nif);
}
