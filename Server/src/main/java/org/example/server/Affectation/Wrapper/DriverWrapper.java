package org.example.server.Affectation.Wrapper;
import lombok.*;
import org.example.server.Affectation.dto.DriverDTO;
import org.example.server.Affectation.dto.PermisDTO;
import org.example.server.Affectation.dto.PermisRemiseDTO;

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
