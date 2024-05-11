package org.example.server.Affectation.Service;

import org.example.server.Affectation.dto.TripDTO;
import org.example.server.Affectation.dto.VehiculeDTO;

import java.util.List;

public interface VehiculeService {
    List<VehiculeDTO> getAllVehicules();
    List<VehiculeDTO> getAvailableVehicules();
    VehiculeDTO getVehiculeById(int id);

    VehiculeDTO saveVehicule(VehiculeDTO vehiculeDTO);

    void deleteVehiculeById(int id);
}
