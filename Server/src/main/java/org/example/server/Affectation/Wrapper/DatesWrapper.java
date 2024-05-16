package org.example.server.Affectation.Wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatesWrapper {
    @JsonProperty("dateDepart")
    private LocalDate dateDepart;

    @JsonProperty("dateArrival")
    private LocalDate dateArrival;
}
