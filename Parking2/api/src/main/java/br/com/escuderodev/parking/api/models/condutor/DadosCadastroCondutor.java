package br.com.escuderodev.parking.api.models.condutor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCondutor(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone,
        @NotBlank
        String endereco
) {
}
