package br.com.escuderodev.api.parking.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalTime;

public record ParkingDTO(
        Long id,
        @NotBlank
        String servico,
        @NotNull
        BigDecimal valorPorHora,
        LocalTime horaInicio,
        LocalTime horaTermino
) {
}
