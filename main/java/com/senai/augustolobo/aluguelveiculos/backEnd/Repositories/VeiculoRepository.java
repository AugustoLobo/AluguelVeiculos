package com.senai.augustolobo.aluguelveiculos.backEnd.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    List<Veiculo> findByDisponivelTrue();
}
