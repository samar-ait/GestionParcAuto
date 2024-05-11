package org.example.server.Affectation.Mapper;

import org.example.server.Affectation.Model.Vehicule;
import org.example.server.Affectation.dto.VehiculeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehiculeMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public VehiculeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VehiculeDTO toVehiculeDTO(Vehicule vehicule) {
        System.out.println("Mapping Vehicule entity to VehiculeDTO");
        return modelMapper.map(vehicule, VehiculeDTO.class);
    }

    public Vehicule toVehicule(VehiculeDTO vehiculeDTO) {
        System.out.println("Mapping VehiculeDTO to Vehicule entity");
        return modelMapper.map(vehiculeDTO, Vehicule.class);
    }
}
