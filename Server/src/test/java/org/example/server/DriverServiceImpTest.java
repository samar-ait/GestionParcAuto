package org.example.server;

import org.example.server.Affectation.Mapper.DriverMapper;
import org.example.server.Affectation.Mapper.PermisMapper;
import org.example.server.Affectation.Mapper.PermisRemiseMapper;
import org.example.server.Affectation.Model.PermisType;
import org.example.server.Affectation.Repository.DriverRepository;
import org.example.server.Affectation.Repository.PermisRepository;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Service.DriverServiceImp;
import org.example.server.Affectation.dto.DriverDTO;
import org.example.server.Affectation.dto.PermisDTO;
import org.example.server.Affectation.dto.PermisRemiseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class DriverServiceImpTest {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PermisRepository permisRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private PermisMapper permisMapper;

    @Autowired
    private PermisRemiseMapper permisRemiseMapper;

    @Autowired
    private DriverServiceImp driverService;

    @BeforeEach
    public void setUp() {
        // Clear the database before each test
        driverService = new DriverServiceImp(driverRepository,permisRepository,tripRepository,driverMapper,permisMapper,permisRemiseMapper);
    }

    @Test
    public void testSaveDriver() {
        // Given
        DriverDTO driverDTO = DriverDTO.builder()
                .cin("JAAAAAA")
                .nom("ait")
                .prenom("samar")
                .adresse("dakhla")
                .dateNaissance(LocalDate.of(2001, 8, 12))
                .disponibilite(true)
                .build();

        PermisDTO permisDTO = PermisDTO.builder()
                .numPermis(12)
                .lieuRemisePermis("Agadir")
                .finValidite(LocalDate.of(2024, 5, 1))
                .build();


        PermisRemiseDTO permisRemiseDTO1 = PermisRemiseDTO.builder()
                .type(PermisType.B)
                .date_remise_permis(LocalDate.of(2020, 1, 1))
                .build();

        PermisRemiseDTO permisRemiseDTO2 = PermisRemiseDTO.builder()
                .type(PermisType.C)
                .date_remise_permis(LocalDate.of(2022, 4, 1))
                .build();

        List<PermisRemiseDTO> permisRemisesDTO = Arrays.asList(permisRemiseDTO1, permisRemiseDTO2);

        // When
        DriverDTO savedDriver = driverService.saveDriver(driverDTO, permisDTO, permisRemisesDTO);

        // Then
        //assert that the saved driver DTO contains the expected values
        assertEquals("JAAAAAA", savedDriver.getCin());

    }
    @Test
    public void testDeleteDriver() {
        // Given
        DriverDTO driverDTO = DriverDTO.builder()
                .cin("JB515847")
                .nom("karima")
                .build();

        // When
        driverService.deleteDriverById("JB515847");

    }

    @Test
    public void testDriverAvailability() {
        DriverDTO driverDTO = DriverDTO.builder()
                .cin("JB515847")
                .nom("karima")
                .build();
        LocalDate dateDepart = LocalDate.of(2024, 5, 15);
        LocalDate dateArrival = LocalDate.of(2024, 5, 20);

        Boolean dispo = driverService.driverAvailability(driverDTO,dateDepart,dateArrival);
        System.out.println("******************************************"+dispo);

        assertEquals(false, dispo);

    }
    @Test
    public void findDriversAvailableBetweenDates() {

        LocalDate dateDepart = LocalDate.of(2024, 5, 15);
        LocalDate dateArrival = LocalDate.of(2024, 5, 20);

        driverService.findDriversAvailableBetweenDates(dateDepart,dateArrival);


    }
}