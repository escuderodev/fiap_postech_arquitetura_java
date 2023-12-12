package br.com.escuderodev.parking.api.controller;

import br.com.escuderodev.parking.api.models.CadastroCondutorEVeiculoDTO;
import br.com.escuderodev.parking.api.models.veiculo.DadosListagemVeiculo;
import br.com.escuderodev.parking.api.models.veiculo.Veiculo;
import br.com.escuderodev.parking.api.service.CondutorService;
import br.com.escuderodev.parking.api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private CondutorService condutorService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemVeiculo>> consultarVeiculos(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        var page = veiculoService.findAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/ativo")
    public ResponseEntity<Page<DadosListagemVeiculo>> consultarVeiculosAtivos(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        var page = veiculoService.findByStatusTrue(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> consultarVeiculoPorId(@PathVariable Long id) {
        var veiculo = veiculoService.findById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarVeiculo(@RequestBody @Valid CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO, UriComponentsBuilder uriBuilder) {
        var veiculo = veiculoService.createVehicle(cadastroCondutorEVeiculoDTO);
        var uri = uriBuilder.path("veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @PostMapping("/cadastrar-para-condutor/{condutorId}")
    @Transactional
    public ResponseEntity cadastrarVeiculoParaCondutorExistente(@PathVariable Long condutorId, @RequestBody @Valid CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO, UriComponentsBuilder uriBuilder) {
        var veiculo = veiculoService.createVehicleForDriver(condutorId, cadastroCondutorEVeiculoDTO);
        var uri = uriBuilder.path("veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarVeiculo(@RequestBody @Valid Veiculo veiculo, @PathVariable Long id) {
        var veiculoDigitado = veiculo;
        veiculoService.update(veiculo, id);
        return ResponseEntity.ok(veiculoDigitado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarVeiculo(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("logica/{id}")
    @Transactional
    public ResponseEntity exclusaoLogicaVeiculo(@PathVariable Long id) {
        veiculoService.logicalDeletionVehicle(id);
        return ResponseEntity.noContent().build();
    }

}