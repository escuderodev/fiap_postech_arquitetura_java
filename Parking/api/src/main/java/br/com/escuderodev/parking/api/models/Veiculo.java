package br.com.escuderodev.parking.api.models;

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
    @Embedded
    private Condutor condutor;

    public Veiculo(@Valid DadosCadastroVeiculo dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.placa = dados.placa();
        this.status = true;
        this.condutor = new Condutor(dados.condutor());
    }

    public void atualizaDados(DadosAtualizaVeiculo dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.placa = dados.placa();
        this.condutor.atualizaDados(dados.condutor());
    }

    public void exclusaoLogica() {
        this.status = false;
    }
}
