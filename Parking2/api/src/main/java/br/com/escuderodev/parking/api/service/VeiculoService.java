package br.com.escuderodev.parking.api.service;

import br.com.escuderodev.parking.api.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.parking.api.models.CadastroCondutorEVeiculoDTO;
import br.com.escuderodev.parking.api.models.condutor.Condutor;
import br.com.escuderodev.parking.api.models.condutor.CondutorRepository;
import br.com.escuderodev.parking.api.models.veiculo.DadosListagemVeiculo;
import br.com.escuderodev.parking.api.models.veiculo.Veiculo;
import br.com.escuderodev.parking.api.models.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CondutorRepository condutorRepository;

    public Page<DadosListagemVeiculo> findAll(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return veiculoRepository.findAll(paginacao).map(DadosListagemVeiculo::new);
    }

    public Page<DadosListagemVeiculo> findByStatusTrue(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return veiculoRepository.findAllByStatusTrue(paginacao).map(DadosListagemVeiculo::new);
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Veículo não encontrado!"));
    }

    public Veiculo createVehicle(CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO) {
        var condutor = new Condutor(cadastroCondutorEVeiculoDTO.getDadosCondutor());
        var veiculo = new Veiculo(cadastroCondutorEVeiculoDTO.getDadosVeiculo(), condutor);
        condutorRepository.save(condutor);
        veiculoRepository.save(veiculo);
        return veiculo;
    }

    public Veiculo createVehicleForDriver(Long condutorId, CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO) {
        var condutor = condutorRepository.getReferenceById(condutorId);
        var veiculo = new Veiculo(cadastroCondutorEVeiculoDTO.getDadosVeiculo(), condutor);
        veiculoRepository.save(veiculo);
        return veiculo;
    }

    public Veiculo update(Veiculo veiculo, Long id) {
        var veiculoDigitado = veiculoRepository.getReferenceById(id);
        veiculoDigitado.atualizaDados(veiculo);
        return veiculoRepository.getReferenceById(id);
    }

    public void delete(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
    }

    public void logicalDeletionVehicle(Long id) {
        var veiculo = veiculoRepository.getReferenceById(id);
        veiculo.exclusaoLogica();
    }

}
