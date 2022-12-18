package es.ull.flights;


import es.ull.passengers.Passenger;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class FlightTest {
    @Test
    @DisplayName("Creación de vuelo con número inválido manejando excepción")
    void creatingFlight() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> new Flight("1234", 4)
        );
        Assertions.assertTrue(thrown.getMessage().contains("Invalid flight number"));
    }

    @Test
    @DisplayName("Creación de vuelo con número inválido")
    @Disabled("No se maneja la exepción")
    void creatingFFlight() {
        new Flight("1234", 4);
    }

    Flight flight = new Flight("AA333", 4);

    @Test
    @DisplayName("Comprobación del número de vuelo")
    void flightNumber() {
        Assertions.assertEquals("AA333",flight.getFlightNumber());
    }

    @Test
    @DisplayName("Comprobación del número de pasajeros")
    void passangersNumber() {
        Assertions.assertEquals(0,flight.getNumberOfPassengers());
    }


}
