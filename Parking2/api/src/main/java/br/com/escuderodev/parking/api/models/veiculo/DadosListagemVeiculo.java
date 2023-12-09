package br.com.escuderodev.parking.api.models.veiculo;

import br.com.escuderodev.parking.api.models.condutor.Condutor;
import br.com.escuderodev.parking.api.models.veiculo.Veiculo;
import jakarta.validation.constraints.NotBlank;

public record DadosListagemVeiculo(
        Long id,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        String placa,
        Boolean status,
        Condutor condutor
) {
        public DadosListagemVeiculo(Veiculo veiculo) {
                this(veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(), veiculo.getStatus(), veiculo.getCondutor());
        }
}
