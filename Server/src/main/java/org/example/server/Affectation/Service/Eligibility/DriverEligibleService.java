package org.example.server.Affectation.Service.Eligibility;

import org.example.server.Affectation.Model.Vehicule;

public interface DriverEligibleService {
    boolean IsDriverEligible(String id_driver, Vehicule vehicule);
}
