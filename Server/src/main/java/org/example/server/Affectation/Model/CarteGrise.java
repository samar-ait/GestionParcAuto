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

    @Column(nullable = false)
    private String imm_anterieure;

    @Column(nullable = false)
    private Date premiere_mise_Circulation;

    @Column(nullable = false)
    private Date MC_MAROC;

    private Date mutation;

    @Column(nullable = false)
    private String usageCG;

    @Column(nullable = false)
    private String proprietaire;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private Date fin_validite;

    @OneToOne
    @JoinColumn(name = "vehicule_fk")
    private Vehicule vehicule;

}
