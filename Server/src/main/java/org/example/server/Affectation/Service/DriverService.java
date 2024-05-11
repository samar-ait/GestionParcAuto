package org.example.server.Affectation.Service;

import org.example.server.Affectation.dto.DriverDTO;
import org.example.server.Affectation.dto.PermisDTO;
import org.example.server.Affectation.dto.PermisRemiseDTO;
import org.example.server.Affectation.dto.TripDTO;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface DriverService {
    List<DriverDTO> getAllDrivers();

    DriverDTO getDriverById(String cin);

    DriverDTO saveDriver(DriverDTO driverDTO, PermisDTO permisDTO, List<PermisRemiseDTO> permisRemiseDTO);

    void deleteDriverById(String cin);

    List<DriverDTO> findDriversAvailableBetweenDates(LocalDate date1, LocalDate date2);

    boolean driverAvailability(DriverDTO driverDTO, LocalDate dateDepart, LocalDate dateArrival);
}
