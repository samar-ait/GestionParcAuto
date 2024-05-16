package org.example.server.Affectation.dto;

import lombok.*;
import org.example.server.Affectation.Model.Permis;
import org.example.server.Affectation.Model.PermisType;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermisRemiseDTO {
    private Long idPermisRemise;
    private PermisType type;
    private LocalDate date_remise_permis;
    private Permis permis;
}
