package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    private String CIN;

    private String nom;

    private String prenom;

    private Date date_naissance;

    private String addresse;

    private boolean disponibilité;

    @OneToMany(mappedBy = "driver")
    private List<Trip> trip;

    @OneToOne
    @JoinColumn(name = "permis_fk")
    private Permis permis;

}
