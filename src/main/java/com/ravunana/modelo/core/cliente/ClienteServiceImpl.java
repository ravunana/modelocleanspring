package com.ravunana.modelo.core.cliente;

import com.ravunana.modelo.shared.exceptions.AppError;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void createCliente(ClienteDTO clienteDTO) {
        var existsEmail = clienteRepository.existsByEmail((clienteDTO.email));

        if ( existsEmail ) {
            throw  new AppError("Email já existe");
        }

        var existsNif = clienteRepository.existsByNif((clienteDTO.nif));

        if ( existsNif ) {
            throw new AppError("Nif já existe");
        }

        var clienteMapper = new ClienteMapper();

        clienteRepository.save(clienteMapper.toEntity(clienteDTO));
    }

    @Override
    public List<Cliente> listClientes() {
        return clienteRepository.findAllClientes();
    }

    @Override
    public Optional<Cliente> showCliente(String id) {
        return Optional.ofNullable(clienteRepository.findByID(id).orElseThrow(() -> new AppError("Cliente não encontrado")));
    }

    @Override
    public void updateCLiente(String id) {
        var findedCliente = showCliente(id);

        clienteRepository.save(findedCliente.get());
    }

    @Override
    public void deleteCliente(String id) {
        var findedCliente = showCliente(id);

        clienteRepository.delete(findedCliente.get());
    }
}
