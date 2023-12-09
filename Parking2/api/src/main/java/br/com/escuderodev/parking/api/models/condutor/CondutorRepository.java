package br.com.escuderodev.parking.api.models.condutor;

import br.com.escuderodev.parking.api.models.condutor.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
