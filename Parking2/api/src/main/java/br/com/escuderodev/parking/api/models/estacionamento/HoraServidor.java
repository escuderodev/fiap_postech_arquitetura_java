package br.com.escuderodev.parking.api.models.estacionamento;

import java.time.LocalDate;
import java.time.LocalTime;

public class HoraServidor {
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
