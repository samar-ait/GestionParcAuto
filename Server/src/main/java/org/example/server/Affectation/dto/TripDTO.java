package org.example.server.Affectation.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.sql.Time;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {
    private int idTrip;
    private String departure;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private int nbrOfPassengers;
    private String statusConfirmation;
    private String vehiculType;
    private int vehiculeId;
    private String driverId;

}
