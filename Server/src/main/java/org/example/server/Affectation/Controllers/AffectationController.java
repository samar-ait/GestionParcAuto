package org.example.server.Affectation.Controllers;

import org.example.server.Affectation.Service.ServiceAffectation;
import org.example.server.Affectation.Wrapper.AffectationWrapper;
import org.example.server.Affectation.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/affectation")
public class AffectationController {
    @Autowired
    private ServiceAffectation serviceAffectation;

    @PostMapping
    public ResponseEntity<TripDTO> affecterTrip(@RequestBody AffectationWrapper affectationWrapper) {
        try {
            TripDTO tripDTO = serviceAffectation.affecter(affectationWrapper);
            if (tripDTO != null) {
                return ResponseEntity.ok(tripDTO);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

}
