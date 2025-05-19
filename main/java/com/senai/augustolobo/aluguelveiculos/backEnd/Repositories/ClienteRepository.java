package com.senai.augustolobo.aluguelveiculos.backEnd.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
