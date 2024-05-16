package org.example.server.Affectation.Service;

import org.example.server.Affectation.dto.TripDTO;

import java.util.List;

public interface TripService {
    List<TripDTO> getAllTrips();

    TripDTO getTripById(Long id);

    TripDTO saveTrip(TripDTO tripDTO);

    //void deleteTripById(int id);

}