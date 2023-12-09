package br.com.escuderodev.parking.api.controller;

import br.com.escuderodev.parking.api.models.condutor.DadosListagemCondutor;
import br.com.escuderodev.parking.api.models.CadastroCondutorEVeiculoDTO;
import br.com.escuderodev.parking.api.models.condutor.Condutor;
import br.com.escuderodev.parking.api.service.CondutorService;
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
@RequestMapping("/condutores")
@CrossOrigin
public class CondutorController {

    @Autowired
    private CondutorService condutorService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemCondutor>> consultarCondutor(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        var page = condutorService.findAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCondutor(@RequestBody @Valid CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO, UriComponentsBuilder uriBuilder) {
        var condutor = condutorService.create(cadastroCondutorEVeiculoDTO);
        var uri = uriBuilder.path("condutores/{id}").buildAndExpand(condutor.getId()).toUri();
        return ResponseEntity.created(uri).body(condutor);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarCondutor(@RequestBody @Valid Condutor condutor, @PathVariable Long id) {
        var condutorDigitado = condutor;
        condutorService.update(condutor, id);
        return ResponseEntity.ok(condutorDigitado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCondutor(@PathVariable Long id) {
        condutorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
