package com.senai.augustolobo.aluguelveiculos.backEnd.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Aluguel;
import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Carro;
import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Cliente;
import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Moto;
import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Veiculo;
import com.senai.augustolobo.aluguelveiculos.backEnd.Repositories.AluguelRepository;
import com.senai.augustolobo.aluguelveiculos.backEnd.Repositories.ClienteRepository;
import com.senai.augustolobo.aluguelveiculos.backEnd.Repositories.VeiculoRepository;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        return clienteRepository.save(cliente);
    }

    public Veiculo cadastrarVeiculo(String modelo, Veiculo.TiposVeiculo tipo, Object especifico) {
        Veiculo veiculo = null;
        if (tipo == Veiculo.TiposVeiculo.CARRO) {
            int numeroDePortas = (Integer) especifico;
            veiculo = new Carro(modelo, numeroDePortas);
        } else if (tipo == Veiculo.TiposVeiculo.MOTO) {
            int ano = (Integer) especifico;
            veiculo = new Moto(modelo, ano);
        }
        return veiculoRepository.save(veiculo);
    }

    public Aluguel registrarAluguel(int clienteId, int veiculoId, LocalDate dataInicio, LocalDate dataFim) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        if (!veiculo.isDisponivel()) {
            throw new RuntimeException("Veículo indisponível");
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setVeiculo(veiculo);
        aluguel.setDataInicio(dataInicio);
        aluguel.setDataFim(dataFim);

        veiculo.setDisponivel(false);

        veiculoRepository.save(veiculo);
        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarAlugueisAtivos() {
        return aluguelRepository.findByDataFimIsNull();
    }

    public void devolverVeiculo(int aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId)
                .orElseThrow(() -> new RuntimeException("Aluguel não resgistrado"));
        Veiculo veiculo = aluguel.getVeiculo();

        veiculo.setDisponivel(true);
        veiculoRepository.save(veiculo);

        aluguel.setDataFim(LocalDate.now());
        aluguelRepository.save(aluguel);
    }

}
