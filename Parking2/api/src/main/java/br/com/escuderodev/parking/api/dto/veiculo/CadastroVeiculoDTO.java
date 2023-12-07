package br.com.escuderodev.parking.api.dto.veiculo;

import br.com.escuderodev.parking.api.dto.condutor.DadosCadastroCondutor;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroVeiculoDTO {
    @Valid
    private DadosCadastroVeiculo dadosVeiculo;

    @Valid
    private DadosCadastroCondutor dadosCondutor;

    // Construtores, getters e setters

    public CadastroVeiculoDTO(DadosCadastroVeiculo dadosVeiculo, DadosCadastroCondutor dadosCondutor) {
        this.dadosVeiculo = dadosVeiculo;
        this.dadosCondutor = dadosCondutor;
    }

    public CadastroVeiculoDTO() {
    }
}
