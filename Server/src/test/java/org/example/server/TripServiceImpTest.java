package org.example.server;

import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Mapper.TripMapper;
import org.example.server.Affectation.Service.TripServiceImp;
import org.example.server.Affectation.dto.TripDTO;
import org.example.server.Affectation.Model.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TripServiceImpTest {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripMapper tripMapper;

    @Autowired
    private TripServiceImp tripService;

    @BeforeEach
    public void setUp() {
        // Clear the database before each test
        tripService = new TripServiceImp(tripRepository,tripMapper);

    }

    @Test
    public void testSaveTrip() {
        // Given
        TripDTO tripDTO = TripDTO.builder()
                .departure("agadir")
                .build();

        // When
        TripDTO savedTrip = tripService.saveTrip(tripDTO);

        // Then
        assertEquals("agadir", savedTrip.getDeparture());        // Add more assertions as needed

        // Add more assertions as needed
    }
    @Test
    public void testDeletTrip() {
        // Given
        TripDTO tripDTO = TripDTO.builder()
                .departure("agadir")
                .build();

        // When
         tripService.deleteTripById(1);

    }
}
