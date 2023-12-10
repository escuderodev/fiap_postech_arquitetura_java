package br.com.escuderodev.parking.api.models.veiculo;

import br.com.escuderodev.parking.api.models.condutor.DadosCadastroCondutor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVeiculo(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        String placa,
        DadosCadastroCondutor condutor
) {
}
