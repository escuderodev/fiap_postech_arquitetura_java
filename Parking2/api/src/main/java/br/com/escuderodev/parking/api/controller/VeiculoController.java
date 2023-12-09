package br.com.escuderodev.parking.api.controller;

import br.com.escuderodev.parking.api.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.parking.api.models.CadastroCondutorEVeiculoDTO;
import br.com.escuderodev.parking.api.models.veiculo.DadosAtualizaVeiculo;
import br.com.escuderodev.parking.api.models.veiculo.DadosListagemVeiculo;
import br.com.escuderodev.parking.api.models.condutor.Condutor;
import br.com.escuderodev.parking.api.models.veiculo.Veiculo;
import br.com.escuderodev.parking.api.models.condutor.CondutorRepository;
import br.com.escuderodev.parking.api.models.veiculo.VeiculoRepository;
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
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CondutorRepository condutorRepository;

    @GetMapping
    public Page<DadosListagemVeiculo> consultarVeiculos(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return veiculoRepository.findAll(paginacao).map(DadosListagemVeiculo::new);
    }

    @GetMapping("/ativo")
    public Page<DadosListagemVeiculo> consultarVeiculosAtivos(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return veiculoRepository.findAllByStatusTrue(paginacao).map(DadosListagemVeiculo::new);
    }

    @GetMapping("/{id}")
    public Veiculo consultarVeiculoPorId(@PathVariable Long id) {
        return veiculoRepository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Veículo não encontrado!"));
    }

    @PostMapping
    @Transactional
    public void cadastrarVeiculo(@RequestBody @Valid CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO) {
        var condutor = new Condutor(cadastroCondutorEVeiculoDTO.getDadosCondutor());
        var veiculo = new Veiculo(cadastroCondutorEVeiculoDTO.getDadosVeiculo(), condutor);
        condutorRepository.save(condutor);
        veiculoRepository.save(veiculo);
    }

    @PostMapping("/cadastrar-para-condutor/{condutorId}")
    @Transactional
    public void cadastrarVeiculoParaCondutorExistente(@PathVariable Long condutorId, @RequestBody @Valid CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO) {
        var condutor = condutorRepository.findById(condutorId).orElseThrow(() -> new IllegalArgumentException("Condutor não encontrado com ID: " + condutorId));
        var veiculo = new Veiculo(cadastroCondutorEVeiculoDTO.getDadosVeiculo(), condutor);
        veiculoRepository.save(veiculo);
    }

    @PutMapping
    @Transactional
    public void  atualizarVeiculo(@RequestBody @Valid DadosAtualizaVeiculo dados) {
        var veiculo = veiculoRepository.getReferenceById(dados.id());
        veiculo.atualizaDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarVeiculo(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
    }

    @DeleteMapping("logica/{id}")
    @Transactional
    public void exclusaoLogicaVeiculo(@PathVariable Long id) {
        var veiculo = veiculoRepository.getReferenceById(id);
        veiculo.exclusaoLogica();
    }

}