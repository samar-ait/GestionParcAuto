package org.example.server.Affectation.Mapper;

import org.example.server.Affectation.Model.Trip;
import org.example.server.Affectation.dto.TripDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public TripMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TripDTO toTripDTO(Trip trip) {
        return modelMapper.map(trip, TripDTO.class);
    }

    public Trip toTrip(TripDTO tripDTO) {
        return modelMapper.map(tripDTO, Trip.class);
    }
}
