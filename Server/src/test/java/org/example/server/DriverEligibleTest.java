package org.example.server;

import org.example.server.Affectation.Mapper.DriverMapper;
import org.example.server.Affectation.Mapper.TripMapper;
import org.example.server.Affectation.Model.*;
import org.example.server.Affectation.Repository.DriverRepository;
import org.example.server.Affectation.Repository.PermisRepository;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Service.Eligibility.DriverEligibleServiceImp;
import org.example.server.Affectation.Service.TripServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DriverEligibleTest {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private PermisRepository permisRepository;

    @Autowired
    private DriverEligibleServiceImp driverEligibleService;

    @Test
    public void testIsDriverEligible() {
        // Créer un conducteur avec un type de permis spécifique
        Permis permis = new Permis();
        permis.setNum_permis(13456);
        List<PermisRemise> permisTypes = new ArrayList<>();
        PermisRemise permisRemise = new PermisRemise();
        permisRemise.setType(PermisType.C);
        permisTypes.add(permisRemise);
        permis.setPermisTypes(permisTypes);
        permisRepository.save(permis);
        Driver driver = new Driver();
        driver.setCIN("JB5147251");
        driver.setPermis(permis);
        driverRepository.save(driver);

        // Créer un véhicule avec un type de permis requis correspondant
        Vehicule vehicule = new Vehicule();
        vehicule.setTypePermisRequis(PermisType.C);

        // Tester un conducteur éligible
        assertTrue(driverEligibleService.IsDriverEligible(driver.getCIN(), vehicule));


    }
}
