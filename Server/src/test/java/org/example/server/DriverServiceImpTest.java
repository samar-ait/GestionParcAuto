package org.example.server;

import org.example.server.Affectation.Mapper.DriverMapper;
import org.example.server.Affectation.Mapper.PermisMapper;
import org.example.server.Affectation.Mapper.PermisRemiseMapper;
import org.example.server.Affectation.Model.PermisType;
import org.example.server.Affectation.Repository.DriverRepository;
import org.example.server.Affectation.Repository.PermisRepository;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Service.DriverServiceImp;
import org.example.server.Affectation.Wrapper.DriverWrapper;
import org.example.server.Affectation.dto.DriverDTO;
import org.example.server.Affectation.dto.PermisDTO;
import org.example.server.Affectation.dto.PermisRemiseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
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
        driverService = new DriverServiceImp(driverRepository,permisRepository,tripRepository,driverMapper,permisMapper,permisRemiseMapper);
    }

    @Test
    public void testSaveDriver() {
        // Given
        DriverDTO driverDTO = DriverDTO.builder()
                .cin("JB111111")
                .nom("bou")
                .prenom("karima")
                .adresse("dcheira")
                .dateNaissance(LocalDate.of(2002, 1, 27))
                .disponibilite(true)
                .build();

        PermisDTO permisDTO = PermisDTO.builder()
                .numPermis(10)
                .lieuRemisePermis("Agadir")
                .finValidite(LocalDate.of(2040, 5, 1))
                .build();


        PermisRemiseDTO permisRemiseDTO1 = PermisRemiseDTO.builder()
                .type(PermisType.B)
                .date_remise_permis(LocalDate.of(2023, 1, 1))
                .build();

        PermisRemiseDTO permisRemiseDTO2 = PermisRemiseDTO.builder()
                .type(PermisType.C)
                .date_remise_permis(LocalDate.of(2024, 4, 1))
                .build();

        List<PermisRemiseDTO> permisRemisesDTO = Arrays.asList(permisRemiseDTO1, permisRemiseDTO2);

        DriverWrapper driverWrapper = new DriverWrapper(driverDTO,permisDTO,permisRemisesDTO);

        // When
        DriverWrapper savedDriverWrapper = driverService.saveDriver(driverWrapper);

        // Then
        //assert that the saved driver DTO contains the expected values
        assertEquals("JB111111", savedDriverWrapper.getDriverDTO().getCin());
    }
    @Test
    public void testDeleteDriver() {
        // Given
        DriverDTO driverDTO = DriverDTO.builder()
                .cin("JB111111")
                .nom("bou")
                .build();

        // When
        driverService.deleteDriverById("JB111111");
    }

    @Test
    public void testDriverAvailability() {
        DriverDTO driverDTO = DriverDTO.builder()
                .cin("JB111111")
                .nom("bou")
                .build();
        LocalDate dateDepart = LocalDate.of(2024, 5, 15);
        LocalDate dateArrival = LocalDate.of(2024, 5, 20);

        Boolean dispo = driverService.driverAvailability(driverDTO,dateDepart,dateArrival);

        assertEquals(false, dispo);
    }
    @Test
    public void findDriversAvailableBetweenDates() {

        LocalDate dateDepart = LocalDate.of(2024, 5, 15);
        LocalDate dateArrival = LocalDate.of(2024, 5, 20);

        driverService.findDriversAvailableBetweenDates(dateDepart,dateArrival);
    }
}