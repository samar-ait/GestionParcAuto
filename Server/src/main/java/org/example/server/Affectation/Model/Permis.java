package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity

public class Permis {
    @Id
    private int num_permis;

    @Column(nullable = false)
    private Date fin_validité;

    @Column(nullable = false)
    private String lieu_remise_permis;

    @OneToOne
    @JoinColumn(name = "driver_fk")
    private Driver driver;

    @OneToMany(mappedBy = "permis",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PermisRemise> permisTypes;
}
