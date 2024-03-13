package org.example.server.Affectation.dto;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class VehiculeDTO {
    private int idVehicule;
    private String marque;
    private String type;
    private int kilemotrage;
    private String typePermisRequis;
    private String assurance;
    private int visiteTech;
    private int vignette;
    private boolean disponibilite;
    private int carteGriseId;

}
