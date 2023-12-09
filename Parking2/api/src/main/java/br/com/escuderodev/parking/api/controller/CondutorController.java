package br.com.escuderodev.parking.api.controller;

import br.com.escuderodev.parking.api.dto.condutor.DadosAtualizaCondutor;
import br.com.escuderodev.parking.api.dto.condutor.DadosListagemCondutor;
import br.com.escuderodev.parking.api.dto.veiculo.CadastroVeiculoDTO;
import br.com.escuderodev.parking.api.models.Condutor;
import br.com.escuderodev.parking.api.repository.CondutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condutores")
@CrossOrigin
public class CondutorController {

    @Autowired
    private CondutorRepository condutorRepository;

    @GetMapping
    public Page<DadosListagemCondutor> consultarCondutor(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return condutorRepository.findAll(paginacao).map(DadosListagemCondutor::new);
    }

    @PostMapping
    @Transactional
    public void cadastrarCondutor(@RequestBody @Valid CadastroVeiculoDTO cadastroVeiculoDTO) {
        var condutor = new Condutor(cadastroVeiculoDTO.getDadosCondutor());
        condutorRepository.save(condutor);
    }

    @PutMapping
    @Transactional
    public void  atualizarCondutor(@RequestBody @Valid DadosAtualizaCondutor dados) {
        var condutor = condutorRepository.getReferenceById(dados.id());
        condutor.atualizaDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarCondutor(@PathVariable Long id) {
        condutorRepository.deleteById(id);
    }
}
