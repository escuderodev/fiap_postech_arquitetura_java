package br.com.escuderodev.parking.api.models;

import br.com.escuderodev.parking.api.models.condutor.DadosCadastroCondutor;
import br.com.escuderodev.parking.api.models.veiculo.DadosCadastroVeiculo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroCondutorEVeiculoDTO {
    @Valid
    private DadosCadastroVeiculo dadosVeiculo;

    @Valid
    private DadosCadastroCondutor dadosCondutor;

}
