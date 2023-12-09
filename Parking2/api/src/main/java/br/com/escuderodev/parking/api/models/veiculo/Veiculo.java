package br.com.escuderodev.parking.api.models.veiculo;

import br.com.escuderodev.parking.api.models.CadastroCondutorEVeiculoDTO;
import br.com.escuderodev.parking.api.models.condutor.Condutor;
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

    public Veiculo(@Valid CadastroCondutorEVeiculoDTO cadastroCondutorEVeiculoDTO) {
        this.marca = cadastroCondutorEVeiculoDTO.getDadosVeiculo().marca();
        this.modelo = cadastroCondutorEVeiculoDTO.getDadosVeiculo().modelo();
        this.placa = cadastroCondutorEVeiculoDTO.getDadosVeiculo().placa();
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
