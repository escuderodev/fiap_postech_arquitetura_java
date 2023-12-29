package br.com.escuderodev.parking.api.models.estacionamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HoraServidor {
    private LocalDateTime horarioServidor = LocalDateTime.now();

    public LocalDateTime getHorarioServidor() {
        return horarioServidor;
    }
}
