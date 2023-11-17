package br.com.escuderodev.api.parking.models;

import br.com.escuderodev.api.parking.dtos.ParkingDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "parking")
public class Parking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;
    private BigDecimal valorPorHora;
    private LocalTime horaInicio;
    private LocalTime horaTermino;

    public Parking() {
    }

    public Parking(ParkingDTO parkingDTO) {
        this.servico = parkingDTO.servico();
        this.valorPorHora = parkingDTO.valorPorHora();
        this.horaInicio = parkingDTO.horaInicio();
        this.horaTermino = parkingDTO.horaTermino();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Objects.equals(id, parking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", servico='" + servico + '\'' +
                ", valorPorHora=" + valorPorHora +
                ", horaInicio=" + horaInicio +
                ", horaTermino=" + horaTermino +
                '}';
    }
}
