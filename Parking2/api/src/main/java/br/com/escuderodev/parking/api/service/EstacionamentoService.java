package br.com.escuderodev.parking.api.service;

import br.com.escuderodev.parking.api.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.parking.api.models.condutor.Condutor;
import br.com.escuderodev.parking.api.models.estacionamento.DadosCadastroEstacionamento;
import br.com.escuderodev.parking.api.models.estacionamento.DadosListagemEstacionamento;
import br.com.escuderodev.parking.api.models.estacionamento.Estacionamento;
import br.com.escuderodev.parking.api.models.estacionamento.EstacionamentoRepository;
import br.com.escuderodev.parking.api.models.veiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Page<DadosListagemEstacionamento> findAll(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return estacionamentoRepository.findAll(paginacao).map(DadosListagemEstacionamento::new);
    }

    public Estacionamento findById(Long id) {
        return estacionamentoRepository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Estacionamento não encontrado!"));
    }

    public Estacionamento create(Veiculo veiculo) {
        var estacionamento = new Estacionamento(new DadosCadastroEstacionamento(veiculo));
        return estacionamentoRepository.save(estacionamento);
    }

    public Estacionamento update(Estacionamento estacionamento, Long id) {
        estacionamento.setId(id);
        estacionamentoRepository.save(estacionamento);
        return estacionamento;
    }

    public void delete(Long id) {
        estacionamentoRepository.deleteById(id);
    }

}
