package com.senai.augustolobo.aluguelveiculos.backEnd.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer>{
    List<Aluguel> findByDataFimIsNull();
}
