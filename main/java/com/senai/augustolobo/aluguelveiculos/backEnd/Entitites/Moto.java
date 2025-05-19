package com.senai.augustolobo.aluguelveiculos.backEnd.Entitites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MOTO") 
public class Moto extends Veiculo {

    private int ano;

    public Moto() {}

    public Moto(String modelo, int ano) {
        super(modelo, TiposVeiculo.MOTO);
        this.ano = ano;
    }

    @Override
    public String getDetalhes() {
        return "Moto Modelo: " + getModelo() + ", Ano: " + ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
