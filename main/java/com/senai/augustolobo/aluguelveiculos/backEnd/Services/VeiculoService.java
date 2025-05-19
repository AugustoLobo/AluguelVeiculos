package com.senai.augustolobo.aluguelveiculos.backEnd.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Veiculo;
import com.senai.augustolobo.aluguelveiculos.backEnd.Repositories.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarVeiculoPorId(Integer id) {
        return veiculoRepository.findById(id);
    }

    public boolean verificarDisponibilidade(int veiculoId) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(veiculoId);
        return veiculo.isPresent() && veiculo.get().isDisponivel();
    }

    public Veiculo retornarVeiculo(int veiculoId) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(veiculoId);
        if (veiculo.isPresent()) {
            Veiculo v = veiculo.get();
            v.setDisponivel(true);
            return veiculoRepository.save(v);
        }
        return null;
    }
}
