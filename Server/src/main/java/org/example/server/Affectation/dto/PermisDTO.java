package org.example.server.Affectation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
@Getter
public class PermisDTO {
    private int numPermis;
    private Date finValidite;
    private String lieuRemisePermis;
    private String driverCin;
    private List<Integer> permisTypesIds; // Assuming you want to include permisTypes IDs in the DTO

    // Constructors, getters, and setters

    public PermisDTO() {
    }

    public PermisDTO(int numPermis, Date finValidite, String lieuRemisePermis, String driverCin,
                     List<Integer> permisTypesIds) {
        this.numPermis = numPermis;
        this.finValidite = finValidite;
        this.lieuRemisePermis = lieuRemisePermis;
        this.driverCin = driverCin;
        this.permisTypesIds = permisTypesIds;
    }
}
