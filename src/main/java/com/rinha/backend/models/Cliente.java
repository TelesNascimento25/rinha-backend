package com.rinha.backend.models;

import java.io.Serializable;

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
public class Cliente implements Serializable{
	private static final long serialVersionUID = 5843953782858713417L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int limite;
    private int saldo;
	public Cliente(int limite, int saldo) {
		this.limite = limite;
		this.saldo = saldo;
	}
	public Cliente() {
	}
}