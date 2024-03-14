package org.example.server;

import org.example.server.Affectation.Model.Vehicule;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Mapper.TripMapper;
import org.example.server.Affectation.Service.TripServiceImp;
import org.example.server.Affectation.dto.TripDTO;
import org.example.server.Affectation.Model.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripServiceImpTest {
    @Mock
    private TripRepository tripRepository;

    @Mock
    private TripMapper tripMapper;

    @InjectMocks
    private TripServiceImp tripService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tripService = new TripServiceImp(tripRepository, tripMapper);
    }

    @Test
    @Transactional
    public void testSaveTrip() {
        // Given
        TripDTO tripDTO = new TripDTO();
        tripDTO.setIdTrip(1);
        tripDTO.setDeparture("Departure");
        tripDTO.setDestination("Destination");
        tripDTO.setDepartureDate(new Date());
        tripDTO.setDepartureTime(new Time(System.currentTimeMillis()));
        tripDTO.setArrivalDate(new Date());
        tripDTO.setArrivalTime(new Time(System.currentTimeMillis()));
        tripDTO.setNbrOfPassengers(2);
        tripDTO.setStatusConfirmation("Confirmed");
        tripDTO.setVehiculType("Car");
        tripDTO.setVehiculeId(1);
        tripDTO.setDriverId(1);

        Trip trip = new Trip();
        trip.setIdTrip(1);
        trip.setDeparture("Departure");
        trip.setDestination("Destination");
        trip.setDepartureDate(new Date());
        trip.setDepartureTime(new Time(System.currentTimeMillis()));
        trip.setArrivalDate(new Date());
        trip.setArrivalTime(new Time(System.currentTimeMillis()));
        trip.setNbrOfPassengers(2);
        trip.setStatus_confirmation("Confirmed");

        when(tripMapper.toTrip(tripDTO)).thenReturn(trip);
        when(tripRepository.save(trip)).thenReturn(trip);
        when(tripMapper.toTripDTO(trip)).thenReturn(tripDTO);

        // When
        TripDTO savedTripDTO = tripService.saveTrip(tripDTO);

        // Then

        assertEquals(tripDTO.getIdTrip(), savedTripDTO.getIdTrip());
        assertEquals(tripDTO.getDeparture(), savedTripDTO.getDeparture());
        assertEquals(tripDTO.getDestination(), savedTripDTO.getDestination());
        assertEquals(tripDTO.getDepartureDate(), savedTripDTO.getDepartureDate());
        assertEquals(tripDTO.getDepartureTime(), savedTripDTO.getDepartureTime());
        assertEquals(tripDTO.getArrivalDate(), savedTripDTO.getArrivalDate());
        assertEquals(tripDTO.getArrivalTime(), savedTripDTO.getArrivalTime());
        assertEquals(tripDTO.getNbrOfPassengers(), savedTripDTO.getNbrOfPassengers());
        assertEquals(tripDTO.getStatusConfirmation(), savedTripDTO.getStatusConfirmation());
        assertEquals(tripDTO.getVehiculType(), savedTripDTO.getVehiculType());
        assertEquals(tripDTO.getVehiculeId(), savedTripDTO.getVehiculeId());
        assertEquals(tripDTO.getDriverId(), savedTripDTO.getDriverId());
    }
}
