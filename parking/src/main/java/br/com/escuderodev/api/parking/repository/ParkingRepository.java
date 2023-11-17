package br.com.escuderodev.api.parking.repository;

import br.com.escuderodev.api.parking.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
