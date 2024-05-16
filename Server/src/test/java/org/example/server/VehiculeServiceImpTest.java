package org.example.server;

import org.example.server.Affectation.Model.PermisType;
import org.example.server.Affectation.Model.Vehicule;
import org.example.server.Affectation.Model.CarteGrise;
import org.example.server.Affectation.Repository.VehiculeRepository;
import org.example.server.Affectation.Repository.CarteGriseRepository;
import org.example.server.Affectation.Service.VehiculeService;
import org.example.server.Affectation.dto.VehiculeDTO;
import org.example.server.Affectation.Mapper.VehiculeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VehiculeServiceImpTest {

    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private CarteGriseRepository carteGriseRepository;

    @Autowired
    private VehiculeService vehiculeService;


    @Autowired
    private VehiculeMapper vehiculeMapper;

    @BeforeEach
    public void setUp() {
        // Clear the database before each test
       // vehiculeRepository.deleteAll();
    }

    @Test
    public void testSaveVehicule() {
        // Given
        VehiculeDTO vehiculeDTO = new VehiculeDTO();
        vehiculeDTO.setMarque("Toyota");
        vehiculeDTO.setKilometrage(10000);
        vehiculeDTO.setTypePermisRequis(PermisType.B);
        vehiculeDTO.setAssurance("Assurance XYZ");
        vehiculeDTO.setVisiteTech(20220501);
        vehiculeDTO.setVignette(20230001);
        vehiculeDTO.setDisponibilite(true);

        // Create a new CarteGrise entity
        CarteGrise carteGrise = new CarteGrise();
        carteGrise.setNum_Immatriculation("ABC");
        // Set other attributes of CarteGrise as needed
        // ...

        // Save the CarteGrise entity
        CarteGrise savedCarteGrise = carteGriseRepository.save(carteGrise);

        // Set the CarteGrise entity to the Vehicule entity
        Vehicule vehicule = vehiculeMapper.toVehicule(vehiculeDTO);
        vehicule.setCarteGrise(savedCarteGrise);

        // Save the Vehicule entity
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);

        // Then
        assertNotNull(savedVehicule.getIdVehicule());
        assertEquals("Toyota", savedVehicule.getMarque());
        assertEquals(PermisType.B, savedVehicule.getTypePermisRequis());
        assertEquals("Assurance XYZ", savedVehicule.getAssurance());
        assertEquals(20220501, savedVehicule.getVisiteTech());
        assertEquals(20230001, savedVehicule.getVignette());

        assertEquals(savedCarteGrise, savedVehicule.getCarteGrise());
    }

}
