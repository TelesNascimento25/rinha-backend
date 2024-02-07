package com.rinha.backend.resources;

import java.util.concurrent.CompletionStage;

import com.rinha.backend.models.Cliente;
import com.rinha.backend.models.Saldo;
import com.rinha.backend.models.Transacao;
import com.rinha.backend.service.ClienteService;

import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes/{id}/transacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransacoesResource {

    @Inject
    ClienteService clienteService;

    @Inject
    Vertx vertx;

    @POST
    public CompletionStage<Response> criarTransacao(@PathParam("id") int id, Transacao transacao) {
        Promise<Response> promise = Promise.promise();
        vertx.runOnContext(v -> {
            Cliente cliente = clienteService.buscarClientePorId(id);

            if (cliente == null) {
                promise.fail(new WebApplicationException("Cliente não encontrado", 404));
                return;
            }

            if (transacao.getTipo().equals("d") && cliente.getSaldo() - transacao.getValor() < cliente.getLimite()) {
                promise.fail(new WebApplicationException("Saldo insuficiente", 422));
                return;
            }

            cliente.setSaldo(cliente.getSaldo() + (transacao.getTipo().equals("c") ? transacao.getValor() : -transacao.getValor()));
            clienteService.atualizarCliente(cliente);

            promise.complete(Response.ok(new Saldo(cliente.getLimite(), cliente.getSaldo())).build());
        });
        return promise.future().toCompletionStage();
    }


}
