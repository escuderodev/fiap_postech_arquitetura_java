package br.com.escuderodev.parking.api.models.veiculo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Page<Veiculo> findAllByStatusTrue(Pageable paginacao);
}
