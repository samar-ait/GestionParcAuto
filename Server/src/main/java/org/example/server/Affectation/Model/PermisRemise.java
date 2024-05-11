package org.example.server.Affectation.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermisRemise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PermisType type;

    private LocalDate date_remise_permis;


    @ManyToOne
    @JoinColumn(name = "permis_id")
    private Permis permis;
}
