package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity

public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdVehicule;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int kilemotrage;

    @Column(nullable = false)
    private String typePermisRequis;

    @Column(nullable = false)
    private String assurance;

    @Column(nullable = false)
    private int visiteTech;

    @Column(nullable = false)
    private int vignette;

    @Column(nullable = false)
    private boolean disponibilite;

    @OneToMany(mappedBy = "vehicule")
    private List<Trip> trip;

    @OneToOne
    @JoinColumn(name = "carteGrise_fk")
    private CarteGrise  carteGrise ;

}
