package org.example.server.Affectation.Controllers;

import org.example.server.Affectation.Service.VehiculeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.server.Affectation.dto.VehiculeDTO;
import org.example.server.Affectation.Service.VehiculeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping
    public VehiculeDTO createVehicule(@RequestBody VehiculeDTO vehiculeDTO) {
        System.out.println("save Vehicule "+vehiculeDTO.getMarque());
        return vehiculeService.saveVehicule(vehiculeDTO);
    }
    @GetMapping("/getAllVehicules")
    public List<VehiculeDTO> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }
    @GetMapping("/getAllAvailableVehicules")
    public List<VehiculeDTO> getAllAvailableVehicules() {
        return vehiculeService.getAvailableVehicules();
    }
    @GetMapping("/{id}")
    public VehiculeDTO getVehicule(@PathVariable int id) {
        return vehiculeService.getVehiculeById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicule(@PathVariable int id) {
        try {
            vehiculeService.deleteVehiculeById(id);
            return ResponseEntity.ok("Vehicle deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting vehicle: " + e.getMessage());
        }
    }
}

