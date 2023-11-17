package br.com.escuderodev.api.parking.controllers;

import br.com.escuderodev.api.parking.dtos.ParkingDTO;
import br.com.escuderodev.api.parking.models.Parking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @PostMapping
    public void cadastrar(@RequestBody ParkingDTO parkingDTO) {
        var parking = new Parking(parkingDTO);
        System.out.println(parking);
    }

}
