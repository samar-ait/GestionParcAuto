package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrip;

    private String departure;

    private String destination;

    private LocalDate departureDate;

    private LocalTime departureTime;

    private LocalDate arrivalDate;

    private LocalTime arrivalTime;

    private int nbrOfPassengers;

    private String statusConfirmation;

    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculType;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

}
