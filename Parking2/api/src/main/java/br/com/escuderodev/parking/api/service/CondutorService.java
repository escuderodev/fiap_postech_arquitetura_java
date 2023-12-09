package br.com.escuderodev.parking.api.service;

import br.com.escuderodev.parking.api.models.CadastroCondutorEVeiculoDTO;
import br.com.escuderodev.parking.api.models.condutor.Condutor;
import br.com.escuderodev.parking.api.models.condutor.CondutorRepository;
import br.com.escuderodev.parking.api.models.condutor.DadosListagemCondutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    public Page<DadosListagemCondutor> findAll(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return condutorRepository.findAll(paginacao).map(DadosListagemCondutor::new);
    }

    public Condutor create(CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO) {
        var condutor = new Condutor(cadastroCondutorEVeiculoDTO.getDadosCondutor());
        return condutorRepository.save(condutor);
    }

    public Condutor update(Condutor condutor, Long id) {
        condutor.setId(id);
        condutorRepository.save(condutor);
        return condutor;
    }

    public void delete(Long id) {

        condutorRepository.deleteById(id);
    }
}
