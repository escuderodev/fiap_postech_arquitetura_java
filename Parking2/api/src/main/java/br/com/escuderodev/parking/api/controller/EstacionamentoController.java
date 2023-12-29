package br.com.escuderodev.parking.api.controller;

import br.com.escuderodev.parking.api.models.estacionamento.DadosListagemEstacionamento;
import br.com.escuderodev.parking.api.service.EstacionamentoService;
import br.com.escuderodev.parking.api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemEstacionamento>> findAll(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        var page = estacionamentoService.findAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity startParking(@Valid @PathVariable Long id, UriComponentsBuilder uriBuilder) {
        var veiculo = veiculoService.findById(id);
        var estacionamento = estacionamentoService.create(veiculo);
        var uri = uriBuilder.path("condutores/{id}").buildAndExpand(estacionamento.getId()).toUri();
        return ResponseEntity.created(uri).body(estacionamento);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity closeParking(@Valid @PathVariable Long id) {
        var estacionamento = estacionamentoService.findById(id);
        estacionamento.calcularTempoDeUtilizacao();
        estacionamento.calculaValorAPagar();
        return ResponseEntity.ok(estacionamento);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCondutor(@PathVariable Long id) {
        estacionamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
