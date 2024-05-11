package org.example.server.Affectation.Service.Eligibility;

import lombok.AllArgsConstructor;
import org.example.server.Affectation.Model.*;
import org.example.server.Affectation.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DriverEligibleServiceImp implements DriverEligibleService{

    @Autowired
    private DriverRepository driverRepository;


    @Override
    public boolean IsDriverEligible (String id_driver, Vehicule vehicule){
        Optional<Driver> optionalDriver = driverRepository.findById(id_driver);
        // Check if the driver exists
        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            List<PermisRemise> driverPermis = driver.getPermis().getPermisTypes();

            // Iterate through the driver's permit types
            for (PermisRemise permis : driverPermis) {
                // Compare each permit type with the required permit type for the vehicle
                if (permis.getType().equals(vehicule.getTypePermisRequis())) {
                    return true;
                }
            }
        }
        return false;
    }

}
