package org.example.server.Affectation.Mapper;

import org.example.server.Affectation.Model.Driver;
import org.example.server.Affectation.dto.DriverDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public DriverMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DriverDTO toDriverDTO(Driver driver) {
        return modelMapper.map(driver, DriverDTO.class);
    }

    public Driver toDriver(DriverDTO driverDTO) {
        return modelMapper.map(driverDTO, Driver.class);
    }
}
