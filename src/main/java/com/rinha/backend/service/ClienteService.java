package com.rinha.backend.service;

import java.util.HashMap;
import java.util.Map;

import com.rinha.backend.models.Cliente;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ClienteService {

    private Map<Integer, Cliente> clientes;

    public ClienteService() {
        this.clientes = new HashMap<>();
        this.clientes.put(1, new Cliente(1, 100000, 0));
        this.clientes.put(2, new Cliente(2, 80000, 0));
        this.clientes.put(3, new Cliente(3, 1000000, 0));
        this.clientes.put(4, new Cliente(4, 10000000, 0));
        this.clientes.put(5, new Cliente(5, 500000, 0));
    }

    public Cliente buscarClientePorId(int id) {
        return this.clientes.get(id);
    }

    public void atualizarCliente(Cliente cliente) {
        this.clientes.put(cliente.getId(), cliente);
    }
}
