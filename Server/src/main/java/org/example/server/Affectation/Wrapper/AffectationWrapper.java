package org.example.server.Affectation.Wrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.server.Affectation.dto.DriverDTO;
import org.example.server.Affectation.dto.TripDTO;
import org.example.server.Affectation.dto.VehiculeDTO;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AffectationWrapper {
    private DriverDTO driverDTO;
    private TripDTO tripDTO;
    private VehiculeDTO vehiculeDTO;
}
