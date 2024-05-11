package org.example.server.Affectation.Mapper;

import org.example.server.Affectation.Model.Permis;
import org.example.server.Affectation.dto.PermisDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermisMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public PermisMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PermisDTO toPermisDTO(Permis permis) {
        return modelMapper.map(permis, PermisDTO.class);
    }

    public Permis toPermis(PermisDTO permisDTO) { return modelMapper.map(permisDTO, Permis.class);}
    }

