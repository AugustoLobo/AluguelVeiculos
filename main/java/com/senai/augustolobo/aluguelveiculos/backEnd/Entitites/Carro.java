package com.senai.augustolobo.aluguelveiculos.backEnd.Entitites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARRO") 
public class Carro extends Veiculo {

    private int numeroDePortas;

    public Carro() {}

    public Carro(String modelo, int numeroDePortas) {
        super(modelo, TiposVeiculo.CARRO);
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public String getDetalhes() {
        return "Carro Modelo: " + getModelo() + ", Número de Portas: " + numeroDePortas;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }
}
