package com.ravunana.modelo.core.cliente;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class ClienteostSQLRepository implements IClienteRepository {

    private final IClienteJPARepository clienteSpringDataRepository;

    public ClienteostSQLRepository(IClienteJPARepository clienteSpringDataRepository) {
        this.clienteSpringDataRepository = clienteSpringDataRepository;
    }
    @Override
    public Optional<Cliente> findByID(String id) {
        return clienteSpringDataRepository.findById(id);
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clienteSpringDataRepository.findAll();
    }
    @Override
    public void save(Cliente cliente) {
        clienteSpringDataRepository.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteSpringDataRepository.delete(cliente);
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsByNif(String nif) {
        return false;
    }
}
