package br.com.escuderodev.parking.api.models;

import br.com.escuderodev.parking.api.dto.veiculo.CadastroVeiculoDTO;
import br.com.escuderodev.parking.api.dto.veiculo.DadosAtualizaVeiculo;
import br.com.escuderodev.parking.api.dto.veiculo.DadosCadastroVeiculo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "Veiculo")
@Table(name = "veiculos")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private Boolean status;
    @ManyToOne
    private Condutor condutor;

    public Veiculo(@Valid CadastroVeiculoDTO cadastroVeiculoDTO) {
        this.marca = cadastroVeiculoDTO.getDadosVeiculo().marca();
        this.modelo = cadastroVeiculoDTO.getDadosVeiculo().modelo();
        this.placa = cadastroVeiculoDTO.getDadosVeiculo().placa();
        this.status = true;
        this.condutor = condutor;
    }

    public Veiculo(DadosCadastroVeiculo dadosVeiculo, Condutor condutor) {
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.placa = dadosVeiculo.placa();
        this.status = true;
        this.condutor = condutor;
    }

    public void atualizaDados(DadosAtualizaVeiculo dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.placa = dados.placa();
    }

    public void exclusaoLogica() {
        this.status = false;
    }
}
