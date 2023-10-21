package br.com.escuderodev.fiap.pet_tech.repository;

import br.com.escuderodev.fiap.pet_tech.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
