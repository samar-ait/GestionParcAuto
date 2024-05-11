package org.example.server.Affectation.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermisDTO {
    private int numPermis;
    private LocalDate finValidite;
    private String lieuRemisePermis;
    private String driverCin;
    private List<Integer> permisTypesIds;

}
