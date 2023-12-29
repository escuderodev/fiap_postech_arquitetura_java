package br.com.escuderodev.parking.api.models.estacionamento;

import br.com.escuderodev.parking.api.models.veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosListagemEstacionamento(
         Long id,
         LocalDateTime horaInicio,
         LocalDateTime horaTermino,
         Long tempoDeUtilizacao,
         BigDecimal valorAPagar,
         Veiculo veiculo
) {
    public DadosListagemEstacionamento(Estacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getHoraInicio(), estacionamento.getHoraTermino(), estacionamento.getTempoDeUtilizacao(), estacionamento.getValorAPagar(), estacionamento.getVeiculo());
    }
}
