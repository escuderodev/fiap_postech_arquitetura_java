package br.com.escuderodev.parking.api.models.estacionamento;

import br.com.escuderodev.parking.api.models.veiculo.Veiculo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity(name = "Estacionamento")
@Table(name = "estacionamentos")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estacionamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime horaInicio;
    private LocalDateTime horaTermino;
    private Long tempoDeUtilizacao;
    private BigDecimal valorPorHora = new BigDecimal(10.00);
    private BigDecimal valorAPagar;
    @OneToOne
    private Veiculo veiculo;

    public Estacionamento() {
    }

    public Estacionamento(DadosCadastroEstacionamento dados) {
        this.horaInicio = LocalDateTime.now();
        this.veiculo = dados.veiculo();
    }

    public void calcularTempoDeUtilizacao() {
        if (this.horaInicio != null) {
            this.horaTermino = LocalDateTime.now();
            Duration tempoEstacionado = Duration.between(horaInicio,horaTermino);
            this.tempoDeUtilizacao = tempoEstacionado.toHours();
            System.out.println("Inicio registrado às: " + horaInicio);
            System.out.println("Saida registrada em " + horaTermino);
            System.out.println("Tempo estacionado: " + tempoEstacionado);
            System.out.println("Tempo total estacionado: " + tempoDeUtilizacao + " horas.");
        } else {
            System.out.println("Erro: registro de entrada não encontrado!");
        }
    }

    public void calculaValorAPagar() {
        this.valorAPagar = this.valorPorHora.multiply(BigDecimal.valueOf(this.tempoDeUtilizacao));
    }
}
