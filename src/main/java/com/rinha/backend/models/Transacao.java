package com.rinha.backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transacao implements Serializable{
	private static final long serialVersionUID = 5882726073781370595L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int valor;
    private String tipo;
    private String descricao;
    private LocalDateTime realizadaEm;
	public Transacao() {
		
	}
	public Transacao(int valor, String tipo, String descricao, LocalDateTime realizadaEm) {
		super();
		this.valor = valor;
		this.tipo = tipo;
		this.descricao = descricao;
		this.realizadaEm = realizadaEm;
	}
	
}
