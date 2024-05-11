package org.example.server.Affectation.dto;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverWrapper {
    private DriverDTO driverDTO;
    private PermisDTO permisDTO;
    private List<PermisRemiseDTO> permisRemisesDTO;
}
