package com.ravunana.modelo.core.cliente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    void createCliente(ClienteDTO clienteDTO);
    List<Cliente> listClientes();
    Optional<Cliente> showCliente(Integer id);
    void updateCLiente(Integer id);
    void deleteCliente(Integer id);
}
