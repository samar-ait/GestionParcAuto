package org.example.server.Affectation.Service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.server.Affectation.Mapper.DriverMapper;
import org.example.server.Affectation.Mapper.PermisMapper;
import org.example.server.Affectation.Mapper.PermisRemiseMapper;
import org.example.server.Affectation.Model.Driver;
import org.example.server.Affectation.Model.Permis;
import org.example.server.Affectation.Model.PermisRemise;
import org.example.server.Affectation.Model.Trip;
import org.example.server.Affectation.Repository.DriverRepository;
import org.example.server.Affectation.Repository.PermisRepository;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Wrapper.DriverWrapper;
import org.example.server.Affectation.dto.DriverDTO;
import org.example.server.Affectation.dto.PermisDTO;
import org.example.server.Affectation.dto.PermisRemiseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DriverServiceImp implements DriverService{

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PermisRepository permisRepository;

    @Autowired
    private TripRepository tripRepository;

    private DriverMapper driverMapper;

    private PermisMapper permisMapper;

    private PermisRemiseMapper permisRemiseMapper;

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> drivers = (List<Driver>)driverRepository.findAll();
        if (drivers.isEmpty()) {
            return Collections.emptyList(); // Return an empty list if no drivers are found
        }
        return mapDriversToDriversDto(drivers); // Use instance of DriverMapper
    }

    // Helper method to map Driver entities to DriverDto objects
    private List<DriverDTO> mapDriversToDriversDto(List<Driver> drivers) {
        return drivers.stream()
                .map(driverMapper::toDriverDTO)
                .collect(Collectors.toList());
    }
    @Override
    public DriverDTO getDriverById(String cin) {
        Optional<Driver> driverOptional = driverRepository.findById(cin);
        return driverOptional.map(driverMapper::toDriverDTO).orElse(null);
    }
    private static final Logger logger = LogManager.getLogger(TripServiceImp.class);

    @Override
    public DriverWrapper saveDriver(DriverWrapper driverWrapper) {
        DriverDTO driverDTO = driverWrapper.getDriverDTO();
        PermisDTO permisDTO = driverWrapper.getPermisDTO();
        List<PermisRemiseDTO> permisRemisesDTO = driverWrapper.getPermisRemisesDTO();

        logger.info("Entering saveDriver()");
        // Log the contents of the driverDTO
        logger.debug("driverDTO: {}", driverDTO);
        logger.debug("permisDTO: {}", permisDTO);

        // Map DTO to entity
        Driver driver = driverMapper.toDriver(driverDTO);

        // Map DTO to entity
        Permis permis = permisMapper.toPermis(permisDTO);

        // Set the manually assigned primary key value
        permis.setNumPermis(permisDTO.getNumPermis());

        // Map DTO to entity
        List<PermisRemise> permisRemises = new ArrayList<PermisRemise>();
        permisRemisesDTO.forEach((permisRemiseDTO)->{
            PermisRemise permisRemise = permisRemiseMapper.toPermisRemise(permisRemiseDTO);
            permisRemise.setPermis(permis);
            permisRemises.add(permisRemise);
        });


        // Associate the permitremises with the permis
        permis.setPermisTypes(permisRemises);

        // permis.setDriver(driver);

        // Associate the permit with the driver
        driver.setPermis(permis);

        Permis savedPermis = permisRepository.save(permis);
        logger.debug("Saved permis: {}", savedPermis);

        Driver savedDriver = driverRepository.save(driver);
        logger.debug("Saved driver: {}", savedDriver);

        DriverWrapper savedDriverWrapper = new DriverWrapper(driverMapper.toDriverDTO(savedDriver),permisMapper.toPermisDTO(savedPermis),permisRemisesDTO);
        return savedDriverWrapper;
    }

    @Override
    public void deleteDriverById(String cin) {
        driverRepository.deleteById(cin);
        logger.info("Driver deleted successfully.");
    }

    @Override
    public List<DriverDTO> findDriversAvailableBetweenDates(LocalDate date1, LocalDate date2)
    {
        List<DriverDTO> allDrivers = this.getAllDrivers();
        List<DriverDTO> availableDrivers = new ArrayList<DriverDTO>();


        for (DriverDTO driverDTO : allDrivers) {
            if (this.driverAvailability(driverDTO, date1, date2)) {
                availableDrivers.add(driverDTO);
            }
        }
        return availableDrivers;
    }

    @Override
    public boolean driverAvailability(DriverDTO driverDTO, LocalDate dateDepart,LocalDate dateArrival) {
        Driver driver = driverMapper.toDriver(this.getDriverById(driverDTO.getCin()));

        if (driver == null) {
            return false;  //Driver not found
        }
        List<Trip> trips = (List<Trip>)tripRepository.findAll();

        for (Trip trip : trips) {
            if(Objects.equals(trip.getDriver().getCIN(), driver.getCIN())){

               if ((dateDepart.isBefore(trip.getArrivalDate()) || dateDepart.isEqual(trip.getArrivalDate())) &&
                        (dateArrival.isAfter(trip.getDepartureDate()) || dateArrival.isEqual(trip.getDepartureDate()))) {
                   return false; //Driver not available
               }
            }
        }
        return true;
    }
}