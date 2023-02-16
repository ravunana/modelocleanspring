package com.ravunana.modelo.core.cliente;

import com.ravunana.modelo.shared.exceptions.AppError;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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

        clienteRepository.save(
                clienteMapper.toEntity(clienteDTO));
    }

    @Override
    public List<Cliente> listClientes() {
        return clienteRepository.findAllClientes();
    }

    @Override
    public Optional<Cliente> showCliente(Integer id) {
        return Optional.ofNullable(clienteRepository.findByID(id).orElseThrow(() -> new AppError("Cliente não encontrado")));
    }

    @Override
    public void updateCLiente(Integer id) {
        var findedCliente = showCliente(id);

        clienteRepository.save(findedCliente.get());
    }

    @Override
    public void deleteCliente(Integer id) {
        var findedCliente = showCliente(id);

        clienteRepository.delete(findedCliente.get());
    }


}
