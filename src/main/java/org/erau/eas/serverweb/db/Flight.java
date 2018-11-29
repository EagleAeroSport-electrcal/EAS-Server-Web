package org.erau.eas.serverweb.db;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "flight_date")
    private Date flightDate;

    @Column(name = "pilot_weight")
    private int pilotWeight;

    @Column(name = "fuel_load")
    private int fuelLoad;

    @Column(name = "takeoff_airport")
    private String takeoffAirport;

    @Column(name = "destination_airport")
    private String destinationAirport;

    @Column(name = "flight_start_time")
    private Time flightStartTime;

    @Column(name = "flight_end_time")
    private Time flightEndTime;
}
