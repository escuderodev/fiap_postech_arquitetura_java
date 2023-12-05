package br.com.escuderodev.parking.api.dto.condutor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCondutor(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone
) {
}