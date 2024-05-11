package org.example.server.Affectation.dto;

import lombok.Setter;
import lombok.Getter;
import org.example.server.Affectation.Model.CarteGrise;
import org.example.server.Affectation.Model.PermisType;
import org.example.server.Affectation.Model.VehiculeType;

import java.util.Date;

@Setter
@Getter
public class VehiculeDTO {
    private int IdVehicule;
    private String marque;
    private VehiculeType type; // Update to match the entity
    private int kilometrage;
    private PermisType typePermisRequis; // Update to match the entity
    private String assurance;
    private int visiteTech;
    private int vignette;
    private boolean disponibilite;
    private CarteGrise carteGrise;
}
