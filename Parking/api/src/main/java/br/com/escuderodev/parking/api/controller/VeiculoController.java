package br.com.escuderodev.parking.api.controller;

import br.com.escuderodev.parking.api.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.parking.api.dto.veiculo.DadosAtualizaVeiculo;
import br.com.escuderodev.parking.api.dto.veiculo.DadosCadastroVeiculo;
import br.com.escuderodev.parking.api.dto.veiculo.DadosListagemVeiculo;
import br.com.escuderodev.parking.api.models.Veiculo;
import br.com.escuderodev.parking.api.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public Page<DadosListagemVeiculo> consultarVeiculos(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemVeiculo::new);
    }

    @GetMapping("/ativo")
    public Page<DadosListagemVeiculo> consultarVeiculosAtivos(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return repository.findAllByStatusTrue(paginacao).map(DadosListagemVeiculo::new);
    }

    @GetMapping("/{id}")
    public Veiculo consultarVeiculoPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Veículo não encontrado!"));
    }

    @PostMapping
    @Transactional
    public void cadastrarVeiculo(@RequestBody @Valid DadosCadastroVeiculo dados) {
        repository.save(new Veiculo(dados));
    }

    @PutMapping
    @Transactional
    public void  atualizarVeiculo(@RequestBody @Valid DadosAtualizaVeiculo dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarVeiculo(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("logica/{id}")
    @Transactional
    public void exclusaoLogicaVeiculo(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.exclusaoLogica();
    }
}