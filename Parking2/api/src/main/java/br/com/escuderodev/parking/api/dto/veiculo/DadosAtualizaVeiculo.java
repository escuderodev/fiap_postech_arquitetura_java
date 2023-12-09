package br.com.escuderodev.parking.api.dto.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaVeiculo(
        @NotNull
        Long id,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        String placa
) {
}
