package org.example.server.Affectation.Controllers;

import org.example.server.Affectation.Model.PermisType;
import org.example.server.Affectation.Model.Vehicule;
import org.example.server.Affectation.Service.Eligibility.DriverEligibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drivers")
public class DriverEligibillityController {

    @Autowired
    private DriverEligibleService driverEligibleService;

    @GetMapping("/{driverId}/checkEligibility/{vehiculeType}")
    public ResponseEntity<String> checkDriverEligibility(@PathVariable String driverId, @PathVariable PermisType vehiculeType) {
        // Here, you can create a Vehicule object with the required type of permit
        Vehicule vehicule = new Vehicule();
        vehicule.setTypePermisRequis(vehiculeType);

        // Call the service method to check eligibility
        boolean isEligible = driverEligibleService.IsDriverEligible(driverId, vehicule);

        if (isEligible) {
            return ResponseEntity.ok("Driver is eligible for the vehicle.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver is not eligible for the vehicle.");
        }
    }
}