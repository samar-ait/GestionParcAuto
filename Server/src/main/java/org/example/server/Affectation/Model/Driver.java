package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity

public class Driver {
    @Id
    private String CIN;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private Date date_naissance;

    @Column(nullable = false)
    private String addresse;

    @Column(nullable = false)
    private boolean disponibilité;

    @OneToMany(mappedBy = "driver")
    private List<Trip> trip;

    @OneToOne
    @JoinColumn(name = "permis_fk")
    private Permis permis;

}
