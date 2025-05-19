package com.senai.augustolobo.aluguelveiculos.backEnd.Entitites;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veiculo", discriminatorType = DiscriminatorType.STRING)
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String modelo;

    private boolean disponivel;

    @Enumerated(EnumType.STRING)
    private TiposVeiculo tipo;

    public Veiculo() {}

    public Veiculo(String modelo, TiposVeiculo tipo) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponivel = true; 
    }

    public abstract String getDetalhes();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public TiposVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TiposVeiculo tipo) {
        this.tipo = tipo;
    }

    public enum TiposVeiculo {
        CARRO, MOTO
    }
}
