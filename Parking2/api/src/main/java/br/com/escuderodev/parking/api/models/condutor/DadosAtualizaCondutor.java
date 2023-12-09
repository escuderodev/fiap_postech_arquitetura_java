package br.com.escuderodev.parking.api.models.condutor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCondutor(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone
) {
}
