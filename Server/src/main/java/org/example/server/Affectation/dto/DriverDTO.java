package org.example.server.Affectation.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private String cin;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String adresse;
    private boolean disponibilite;
    private int permisId;
}
