package com.senai.augustolobo.aluguelveiculos.backEnd.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senai.augustolobo.aluguelveiculos.backEnd.Services.AluguelService;
import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Aluguel;
import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Cliente;
import com.senai.augustolobo.aluguelveiculos.backEnd.Entitites.Veiculo;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/cliente")
    public Cliente cadastrarCliente(@RequestParam String nome, @RequestParam String cpf) {
        return aluguelService.cadastrarCliente(nome, cpf);
    }

    @PostMapping("/veiculo")
    public Veiculo cadastrarVeiculo(@RequestParam String modelo, @RequestParam Veiculo.TiposVeiculo tipo, 
                                     @RequestParam Object especifico) {
        return aluguelService.cadastrarVeiculo(modelo, tipo, especifico);
    }

    @PostMapping("/registrar")
    public Aluguel registrarAluguel(@RequestParam int clienteId, @RequestParam int veiculoId, 
                                    @RequestParam String dataInicio, @RequestParam String dataFim) {
        return aluguelService.registrarAluguel(clienteId, veiculoId, LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
    }

    @GetMapping("/ativos")
    public List<Aluguel> listarAlugueisAtivos() {
        return aluguelService.listarAlugueisAtivos();
    }

    @PostMapping("/devolver")
    public void devolverVeiculo(@RequestParam int aluguelId) {
        aluguelService.devolverVeiculo(aluguelId);
    }
}
