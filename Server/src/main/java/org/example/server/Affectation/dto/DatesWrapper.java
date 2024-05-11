package org.example.server.Affectation.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatesWrapper {
    private LocalDate dateDepart;
    private LocalDate dateArrival;
}
