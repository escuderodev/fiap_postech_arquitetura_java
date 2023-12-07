package br.com.escuderodev.parking.api.repository;

import br.com.escuderodev.parking.api.models.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
