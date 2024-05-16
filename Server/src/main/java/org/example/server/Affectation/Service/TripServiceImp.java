package org.example.server.Affectation.Service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.server.Affectation.Mapper.TripMapper;
import org.example.server.Affectation.Model.Driver;
import org.example.server.Affectation.Model.Trip;
import org.example.server.Affectation.Repository.TripRepository;
import org.example.server.Affectation.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TripServiceImp implements TripService {

    @Autowired
    private TripRepository tripRepository;

    private TripMapper tripMapper; // Inject TripMapper

    @Override
    public List<TripDTO> getAllTrips() {
        List<Trip> trips = (List<Trip>) tripRepository.findAll();
        if (trips.isEmpty()) {
            return Collections.emptyList(); // Return an empty list if no trips are found
        }
        return mapTripsToTripDto(trips); // Use instance of TripMapper
    }

    // Helper method to map Trip entities to TripDto objects
    private List<TripDTO> mapTripsToTripDto(List<Trip> trips) {
        return trips.stream()
                .map(tripMapper::toTripDTO) // Use instance of TripMapper
                .collect(Collectors.toList());
    }

    @Override
    public TripDTO getTripById(Long id) {
        Optional<Trip> tripOptional = tripRepository.findById(id);
        return tripOptional.map(tripMapper::toTripDTO).orElse(null); // Use instance of TripMapper
    }

    private static final Logger logger = LogManager.getLogger(TripServiceImp.class);
    @Override
    public TripDTO saveTrip(TripDTO tripDTO) {
        logger.info("Entering myMethod()");
        // Log the contents of the tripDTO
        logger.debug("tripDTO: {}", tripDTO);
        Trip trip = tripMapper.toTrip(tripDTO); // Use instance of TripMapper
        Trip savedTrip = tripRepository.save(trip);
        logger.debug("Saved trip: {}", savedTrip);
        return tripMapper.toTripDTO(savedTrip); // Use instance of TripMapper
    }

}
