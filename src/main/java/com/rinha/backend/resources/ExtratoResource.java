package com.rinha.backend.resources;

import java.time.LocalDateTime;
import java.util.List;

import com.rinha.backend.models.Cliente;
import com.rinha.backend.models.Extrato;
import com.rinha.backend.models.Transacao;
import com.rinha.backend.service.ClienteService;
import com.rinha.backend.service.TransacaoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes/{id}/extrato")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExtratoResource {

    @Inject
    ClienteService clienteService;

    @Inject
    TransacaoService transacaoService;

    @GET
    public Response obterExtrato(@PathParam("id") int id) {
        Cliente cliente = clienteService.buscarClientePorId(id);

        if (cliente == null) {
            return Response.status(404).build();
        }

        List<Transacao> ultimasTransacoes = transacaoService.buscarUltimasTransacoesPorClienteId(id);

        return Response.ok(new Extrato(cliente.getSaldo(), LocalDateTime.now(), cliente.getLimite(), ultimasTransacoes)).build();
    }
}
