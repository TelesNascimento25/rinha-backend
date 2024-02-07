package com.rinha.backend.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Saldo implements Serializable {
    private static final long serialVersionUID = 90788780826246704L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("limite") 
    private int limite;

    @JsonProperty("saldo") 
    private int saldo;

    public Saldo(int limite, int saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }

    public Saldo() {
    }
}
