package org.example.server.Affectation.dto;

import java.util.Date;
import java.sql.Time;

import lombok.*;

@Setter
@Getter
@Builder
public class TripDTO {
    private int idTrip;
    private String departure;
    private String destination;
    private Date departureDate;
    private Time departureTime;
    private Date arrivalDate;
    private Time arrivalTime;
    private int nbrOfPassengers;
    private String statusConfirmation;
    private String vehiculType;
    private int vehiculeId;
    private int driverId;

    // Constructors, getters, and setters

    public TripDTO() {
    }

    public TripDTO(int idTrip, String departure, String destination, Date departureDate, Time departureTime,
                   Date arrivalDate, Time arrivalTime, int nbrOfPassengers, String statusConfirmation,
                   String vehiculType, int vehiculeId, int driverId) {
        this.idTrip = idTrip;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.nbrOfPassengers = nbrOfPassengers;
        this.statusConfirmation = statusConfirmation;
        this.vehiculType = vehiculType;
        this.vehiculeId = vehiculeId;
        this.driverId = driverId;
    }


}
