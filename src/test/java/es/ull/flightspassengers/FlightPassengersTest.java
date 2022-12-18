package es.ull.flightspassengers;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FlightPassengersTest {

    Flight flight = new Flight("AA333", 4);
    Passenger pasajero = new Passenger("1234","Angel","EE");



    @Test
    @DisplayName("Asignando vuelo")
    void passangerFlight() {
        pasajero.setFlight(flight);
        Assertions.assertEquals(flight, pasajero.getFlight());
    }

    @Test
    @DisplayName("Accediendo a un vuelo")
    void passangerJoinFlight() {
        pasajero.setFlight(null);
        pasajero.joinFlight(flight);
        Assertions.assertEquals(flight, pasajero.getFlight());
    }


    @Test
    @DisplayName("Añadiendo pasajeros")
    void passangerAdd() {
        Assertions.assertTrue(flight.addPassenger(new Passenger("1234","Angel","EE")));
        Assertions.assertEquals(1,flight.getNumberOfPassengers());
    }

    @Test
    @DisplayName("Eliminando pasajeros")
    void passangerRemove() {
        Assertions.assertFalse(flight.removePassenger(new Passenger("1234","Angel","EE")));
        Assertions.assertEquals(0,flight.getNumberOfPassengers());
    }
}
