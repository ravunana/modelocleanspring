package com.ravunana.modelo.core.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Validated
public class ClienteController {
    @Autowired
    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> index() {
        var clienteMapper = new ClienteMapper();
        var clientes = clienteService.listClientes();
        return clienteMapper.toListDto(clientes);
    }

    @PostMapping
    public void createNewCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.createCliente(clienteDTO); }
}
