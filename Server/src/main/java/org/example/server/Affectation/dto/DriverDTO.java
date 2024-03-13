package org.example.server.Affectation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class DriverDTO {
    private String cin;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private boolean disponibilite;
    private List<Integer> tripIds;  // Assuming you want to include trip IDs in the DTO
    private int permisId;

    // Constructors, getters, and setters

    public DriverDTO() {
    }

    public DriverDTO(String cin, String nom, String prenom, Date dateNaissance,
                     String adresse, boolean disponibilite, List<Integer> tripIds, int permisId) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.disponibilite = disponibilite;
        this.tripIds = tripIds;
        this.permisId = permisId;
    }
}
