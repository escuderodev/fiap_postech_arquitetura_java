package br.com.escuderodev.fiap.pet_tech.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(
        UUID idproduct,
        String nameProduct,
        String description,
        BigDecimal valor,
        String urlImage
) {
}
