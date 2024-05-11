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

public class Permis {
    @Id
    private int num_permis;

    private Date fin_validité;

    private String lieu_remise_permis;

    @OneToOne
    @JoinColumn(name = "driver_fk")
    private Driver driver;

    @OneToMany(mappedBy = "permis",cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.EAGER)
    private List<PermisRemise> permisTypes;
}
