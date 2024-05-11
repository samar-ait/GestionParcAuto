package org.example.server.Affectation.Mapper;

import org.example.server.Affectation.Model.PermisRemise;
import org.example.server.Affectation.dto.PermisRemiseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermisRemiseMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public PermisRemiseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PermisRemiseDTO toPermisRemiseDTO(PermisRemise permisRemise) {
        return modelMapper.map(permisRemise, PermisRemiseDTO.class);
    }

    public PermisRemise toPermisRemise(PermisRemiseDTO permisRemiseDTO) {
        return modelMapper.map(permisRemiseDTO, PermisRemise.class);}
}
