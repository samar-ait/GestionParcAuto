package org.example.server.Affectation.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrip;

    @Column(nullable = false)
    private String departure;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private Date departureDate;

    @Column(nullable = false)
    private Time departureTime;

    @Column(nullable = false)
    private Date arrivalDate;

    @Column(nullable = false)
    private Time arrivalTime;

    @Column(nullable = false)
    private int nbrOfPassengers;

    @Column(nullable = false)
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
