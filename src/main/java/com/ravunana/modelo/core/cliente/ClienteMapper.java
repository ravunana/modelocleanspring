package com.ravunana.modelo.core.cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public Cliente toEntity(ClienteDTO clienteDTO) {
        final Cliente cliente = new Cliente( clienteDTO.nome, clienteDTO.email, clienteDTO.aniversario, clienteDTO.nif  );
        return cliente;
    }

    public ClienteDTO toDto(Cliente cliente) {
        var clienteDTO = new ClienteDTO();
        clienteDTO.nome = cliente.getNome();
        clienteDTO.email = cliente.getEmail();
        clienteDTO.aniversario = cliente.getAniversario();
        clienteDTO.nif = cliente.getNif();
        return clienteDTO;
    }

    public List<ClienteDTO> toListDto(List<Cliente> clientes) {
        List<ClienteDTO> list = new ArrayList<>();

        for ( var cliente : clientes) {
            var clienteDTO = new ClienteDTO();

            clienteDTO.nome = cliente.getNome();
            clienteDTO.email = cliente.getEmail();
            clienteDTO.aniversario = cliente.getAniversario();
            clienteDTO.nif = cliente.getNif();

            list.add(clienteDTO);
        }

        return list;
    }
}
