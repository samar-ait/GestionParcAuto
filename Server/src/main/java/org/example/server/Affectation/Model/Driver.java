package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    private LocalDate dateNaissance;

    private String adresse;

    private boolean disponibilite;

    @OneToMany(mappedBy = "driver")
    private List<Trip> trip;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "permis_fk")
    private Permis permis;

}
