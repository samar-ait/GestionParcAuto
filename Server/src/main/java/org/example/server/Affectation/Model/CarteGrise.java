package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class CarteGrise {
    @Id
    private String num_Immatriculation;


    private String imm_anterieure;


    private Date premiere_mise_Circulation;


    private Date MC_MAROC;

    private Date mutation;


    private String usageCG;


    private String proprietaire;


    private String adresse;


    private Date fin_validite;

    @OneToOne
    @JoinColumn(name = "vehicule_fk")
    private Vehicule vehicule;

}
