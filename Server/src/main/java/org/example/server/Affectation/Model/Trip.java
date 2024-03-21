package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
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


    private Date departureDate;


    private Time departureTime;


    private Date arrivalDate;


    private Time arrivalTime;


    private int nbrOfPassengers;


    private String status_confirmation;

    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculType;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "driver_id")
    private Driver driver;

}
