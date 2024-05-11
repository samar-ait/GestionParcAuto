package org.example.server.Affectation.Controllers;
import org.example.server.Affectation.Service.DriverService;
import org.example.server.Affectation.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.server.Affectation.Service.DriverService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public DriverDTO createDriver(@RequestBody DriverWrapper request) {
        System.out.println("save Driver "+request.getDriverDTO().getCin());
        System.out.println("save Permis "+request.getPermisDTO().getNumPermis());
        System.out.println("save Permis "+request.getPermisRemisesDTO().size());

        //return new ResponseEntity<>(savedDriver, HttpStatus.CREATED).getBody();

        return driverService.saveDriver(request.getDriverDTO(), request.getPermisDTO(), request.getPermisRemisesDTO());
    }
    @GetMapping("/getAllDrivers")
    public List<DriverDTO> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public DriverDTO getDriver(@PathVariable String id) {
        return driverService.getDriverById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable String id) {
        try {
            driverService.deleteDriverById(id);
            return ResponseEntity.ok("Driver deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting driver: " + e.getMessage());
        }
    }

    @GetMapping("/getAllDriversAvailable")
    public ResponseEntity<List<DriverDTO>> findDriversAvailableBetweenDates(@RequestBody DatesWrapper request) {
        LocalDate departureDate = request.getDateDepart();
        LocalDate arrivalDate = request.getDateArrival();
        List<DriverDTO> availableDrivers =  driverService.findDriversAvailableBetweenDates(departureDate,arrivalDate);
        if (availableDrivers.isEmpty()) {
            return ResponseEntity.noContent().build(); // Pas de contenu disponible
        } else {
            return ResponseEntity.ok(availableDrivers); // Retourne les conducteurs disponibles
        }
    }
}
