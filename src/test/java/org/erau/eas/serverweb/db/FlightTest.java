package org.erau.eas.serverweb.db;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlightTest {
    @Test
    public void getSetTest(){
        Time startTime = Time.valueOf(LocalTime.now());
        Flight flight = new Flight();
        flight.setFlightStartTime(startTime);
        flight.setDestinationAirport("KBUR");
        flight.setFlightDate(Date.valueOf(LocalDate.of(2018, 4, 26)));
        flight.setFuelLoad(100);
        flight.setId(1);
        flight.setPilotWeight(150);
        flight.setTakeoffAirport("KPRC");
        Time endTime = Time.valueOf(LocalTime.now());
        flight.setFlightEndTime(endTime);

        assertEquals("KBUR", flight.getDestinationAirport());
        assertEquals(Date.valueOf(LocalDate.of(2018, 4, 26)),flight.getFlightDate());
        assertEquals(startTime, flight.getFlightStartTime());
        assertEquals(endTime, flight.getFlightEndTime());
        assertEquals(100,flight.getFuelLoad());
        assertEquals(1, flight.getId());
        assertEquals(150, flight.getPilotWeight());
        assertEquals("KPRC", flight.getTakeoffAirport());
    }
}
