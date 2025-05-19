package com.senai.augustolobo.aluguelveiculos.backEnd.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Veiculo;
import com.senai.augustolobo.aluguelveiculos.backEnd.Services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.cadastrarVeiculo(veiculo);
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> buscarVeiculoPorId(@PathVariable Integer id) {
        return veiculoService.buscarVeiculoPorId(id);
    }

    @GetMapping("/disponibilidade/{id}")
    public boolean verificarDisponibilidade(@PathVariable int id) {
        return veiculoService.verificarDisponibilidade(id);
    }

    @PutMapping("/retornar/{id}")
    public Veiculo retornarVeiculo(@PathVariable int id) {
        return veiculoService.retornarVeiculo(id);
    }
}