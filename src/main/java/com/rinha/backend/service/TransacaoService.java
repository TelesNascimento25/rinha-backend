package com.rinha.backend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rinha.backend.models.Cliente;
import com.rinha.backend.models.Transacao;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransacaoService {

    private Map<Integer, List<Transacao>> transacoesPorCliente;

    public TransacaoService() {
        this.transacoesPorCliente = new HashMap<>();
    }

    public void criarTransacao(Cliente cliente, Transacao transacao) {
        List<Transacao> transacoesDoCliente = this.transacoesPorCliente.getOrDefault(cliente.getId(), new ArrayList<>());
        transacoesDoCliente.add(transacao);
        this.transacoesPorCliente.put(cliente.getId(), transacoesDoCliente);
    }


    public List<Transacao> buscarTransacoesPorClienteId(int id) {
        return this.transacoesPorCliente.get(id);
    }

    public List<Transacao> buscarUltimasTransacoesPorClienteId(int id) {
        List<Transacao> transacoes = this.transacoesPorCliente.get(id);
        if (transacoes == null) {
            return Collections.emptyList();
        }
        transacoes.sort(Comparator.comparing(Transacao::getRealizadaEm).reversed());
        return transacoes.subList(0, Math.min(transacoes.size(), 10));
    }

}
