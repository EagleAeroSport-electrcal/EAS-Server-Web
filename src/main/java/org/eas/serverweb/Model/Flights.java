package org.eas.serverweb.Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "flights")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Flights() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public int getPilotWeight() {
        return pilotWeight;
    }

    public void setPilotWeight(int pilotWeight) {
        this.pilotWeight = pilotWeight;
    }

    public int getFuelLoad() {
        return fuelLoad;
    }

    public void setFuelLoad(int fuelLoad) {
        this.fuelLoad = fuelLoad;
    }

    public String getTakeoffAirport() {
        return takeoffAirport;
    }

    public void setTakeoffAirport(String takeoffAirport) {
        this.takeoffAirport = takeoffAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Time getFlightStartTime() {
        return flightStartTime;
    }

    public void setFlightStartTime(Time flightStartTime) {
        this.flightStartTime = flightStartTime;
    }

    public Time getFlightEndTime() {
        return flightEndTime;
    }

    public void setFlightEndTime(Time flightEndTime) {
        this.flightEndTime = flightEndTime;
    }
}
