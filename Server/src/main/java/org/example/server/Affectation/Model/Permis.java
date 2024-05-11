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
public class Permis {
    @Id
    private int numPermis;

    private LocalDate finValidite;

    private String lieuRemisePermis;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "driver_fk")
    private Driver driver;

    @OneToMany(mappedBy = "permis",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PermisRemise> permisTypes;
}
