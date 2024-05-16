package org.example.server;

import org.example.server.Affectation.Mapper.DriverMapper;
import org.example.server.Affectation.Mapper.TripMapper;
import org.example.server.Affectation.Mapper.VehiculeMapper;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Repository.VehiculeRepository;
import org.example.server.Affectation.Service.DriverService;
import org.example.server.Affectation.Service.ServiceAffectation;
import org.example.server.Affectation.Wrapper.AffectationWrapper;
import org.example.server.Affectation.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AffectationServiceTest {

    @Autowired
    private DriverService driverService;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripMapper tripMapper;

    @Autowired
    private VehiculeMapper vehiculeMapper;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private ServiceAffectation serviceAffectation;

    @BeforeEach
    public void setUp() {
        serviceAffectation = new ServiceAffectation(driverService,vehiculeRepository,tripRepository,tripMapper,vehiculeMapper,driverMapper);
    }

    @Test
    public void testAffecter() {
        // Given
        DriverDTO driverDTO = DriverDTO.builder()
                .cin("BBBBBB")
                .build();

        VehiculeDTO vehiculeDTO = VehiculeDTO.builder()
                .IdVehicule(1)
                .build();

        TripDTO tripDTO = TripDTO.builder()
                .departure("Agadir")
                .destination("Rabat")
                .departureDate(LocalDate.of(2024, 2, 1))
                .departureTime(LocalTime.of(1, 8, 30))
                .arrivalDate(LocalDate.of(2024, 2, 2))
                .arrivalTime(LocalTime.of(2, 8, 30))
                .nbrOfPassengers(50)
                .statusConfirmation("confirmé")
                .vehiculType("Bus")
                .build();

        AffectationWrapper affectationWrapper = new AffectationWrapper(driverDTO,tripDTO,vehiculeDTO);

        // When
        TripDTO savedTrip = serviceAffectation.affecter(affectationWrapper);

        // Then
        //assert that the saved driver DTO contains the expected values
        //assertEquals("JB111111", savedTrip.getDriverId());
       // assertEquals(1, savedTrip.getVehiculeId());
    }

}
