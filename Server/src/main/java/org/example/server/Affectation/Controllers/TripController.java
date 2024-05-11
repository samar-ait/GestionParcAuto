package org.example.server.Affectation.Controllers;

import org.example.server.Affectation.Service.TripService;

import org.example.server.Affectation.Service.TripServiceImp;
import org.example.server.Affectation.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping
    public TripDTO createTrip(@RequestBody TripDTO tripDTO) {
        System.out.println("save Trip "+tripDTO.getIdTrip());
        return tripService.saveTrip(tripDTO);
    }
}
