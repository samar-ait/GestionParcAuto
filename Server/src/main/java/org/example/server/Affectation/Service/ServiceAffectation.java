package org.example.server.Affectation.Service;

import lombok.AllArgsConstructor;
import org.example.server.Affectation.Mapper.DriverMapper;
import org.example.server.Affectation.Mapper.TripMapper;
import org.example.server.Affectation.Mapper.VehiculeMapper;
import org.example.server.Affectation.Model.Trip;
import org.example.server.Affectation.Model.Vehicule;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.Repository.VehiculeRepository;
import org.example.server.Affectation.Wrapper.AffectationWrapper;
import org.example.server.Affectation.dto.DriverDTO;
import org.example.server.Affectation.dto.TripDTO;
import org.example.server.Affectation.dto.VehiculeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceAffectation {

    @Autowired
    private DriverService driverService;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private TripRepository tripRepository;

    private TripMapper tripMapper;
    private VehiculeMapper vehiculeMapper;
    private DriverMapper driverMapper;

    public TripDTO affecter(AffectationWrapper affectationWrapper) {
        TripDTO tripDTO = affectationWrapper.getTripDTO();
        DriverDTO driverDTO = affectationWrapper.getDriverDTO();
        VehiculeDTO vehiculeDTO = affectationWrapper.getVehiculeDTO();

        if(driverService.driverAvailability(driverDTO,tripDTO.getDepartureDate(),tripDTO.getArrivalDate())){

            Optional<Vehicule> vehiculeOptional = vehiculeRepository.findById(vehiculeDTO.getIdVehicule());
            if (vehiculeOptional.isEmpty()) {
                throw new RuntimeException("Vehicule with ID " + vehiculeDTO.getIdVehicule() + " not found");
            }

            Trip trip = tripMapper.toTrip(tripDTO);
            //affecter vehicule et driver au trip
            trip.setVehicule(vehiculeMapper.toVehicule(vehiculeDTO));
            trip.setDriver(driverMapper.toDriver(driverDTO));
            //save trip
            Trip savedTrip = tripRepository.save(trip);

            return tripMapper.toTripDTO(savedTrip);
    }
        return null; // driver is not available
    }
}
