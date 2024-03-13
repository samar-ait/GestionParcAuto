package org.example.server.Affectation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter

public class CarteGriseDTO {
    private String numImmatriculation;
    private String immAnterieure;
    private Date premiereMiseCirculation;
    private Date mcMaroc;
    private Date mutation;
    private String usageCG;
    private String proprietaire;
    private String adresse;
    private Date finValidite;
    private int vehiculeId;

    // Constructors, getters, and setters

    public CarteGriseDTO() {
    }

    public CarteGriseDTO(String numImmatriculation, String immAnterieure, Date premiereMiseCirculation,
                         Date mcMaroc, Date mutation, String usageCG, String proprietaire, String adresse,
                         Date finValidite, int vehiculeId) {
        this.numImmatriculation = numImmatriculation;
        this.immAnterieure = immAnterieure;
        this.premiereMiseCirculation = premiereMiseCirculation;
        this.mcMaroc = mcMaroc;
        this.mutation = mutation;
        this.usageCG = usageCG;
        this.proprietaire = proprietaire;
        this.adresse = adresse;
        this.finValidite = finValidite;
        this.vehiculeId = vehiculeId;
    }
}
