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

    private String marque;


    @Enumerated(EnumType.STRING)
    private VehiculeType type;

    private int kilometrage;

    private PermisType typePermisRequis;

    private String assurance;

    private int visiteTech;

    private int vignette;

    private boolean disponibilite;

    @OneToMany(mappedBy = "vehicule")
    private List<Trip> trip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteGrise_fk")
    private CarteGrise  carteGrise ;

}
