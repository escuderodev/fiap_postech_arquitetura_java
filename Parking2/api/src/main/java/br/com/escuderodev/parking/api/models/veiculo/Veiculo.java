package br.com.escuderodev.parking.api.models.veiculo;

import br.com.escuderodev.parking.api.models.CadastroCondutorEVeiculoDTO;
import br.com.escuderodev.parking.api.models.condutor.Condutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Optional;

@Entity(name = "Veiculo")
@Table(name = "veiculos")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Veiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private Boolean status;
    @ManyToOne
    private Condutor condutor;

    public Veiculo(@Valid DadosCadastroVeiculo dadosVeiculo, Condutor condutor) {
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.placa = dadosVeiculo.placa();
        this.status = true;
        this.condutor = condutor;
    }

    public void exclusaoLogica() {
        this.status = false;
    }

    public void atualizaDados(Veiculo veiculo) {
        this.marca = veiculo.marca;
        this.modelo = veiculo.modelo;
        this.placa = veiculo.placa;
    }
}
