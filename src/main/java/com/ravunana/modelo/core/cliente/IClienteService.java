package com.ravunana.modelo.core.cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    void createCliente(ClienteDTO clienteDTO);
    List<Cliente> listClientes();
    Optional<Cliente> showCliente(String id);
    void updateCLiente(String id);
    void deleteCliente(String id);
}
