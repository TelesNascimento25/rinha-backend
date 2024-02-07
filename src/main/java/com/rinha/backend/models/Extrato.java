package com.rinha.backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Extrato implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private static final long serialVersionUID = -5869611436843435102L;
	private int total;
    private LocalDateTime dataExtrato;
    private int limite;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transacao> ultimasTransacoes;
	public Extrato(int total, LocalDateTime dataExtrato, int limite, List<Transacao> ultimasTransacoes) {
		super();
		this.total = total;
		this.dataExtrato = dataExtrato;
		this.limite = limite;
		this.ultimasTransacoes = ultimasTransacoes;
	}
    public Extrato() {
    	
    }
}
