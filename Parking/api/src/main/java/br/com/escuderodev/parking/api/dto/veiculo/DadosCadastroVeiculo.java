package br.com.escuderodev.parking.api.dto.veiculo;

import br.com.escuderodev.parking.api.dto.condutor.DadosCadastroCondutor;
import br.com.escuderodev.parking.api.models.Condutor;
import jakarta.validation.constraints.NotBlank;

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
