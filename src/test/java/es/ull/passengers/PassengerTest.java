package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerTest {
    @Test
    @DisplayName("Creación de pasajero con país inválido manejando excepción")
    void creatingPassanger() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> new Passenger("1234","Angel","abc")
        );
        Assertions.assertTrue(thrown.getMessage().contains("Invalid country code"));
    }

    @Test
    @DisplayName("Creación de pasajero con país inválido")
    @Disabled("No se maneja la exepción")
    void creatingPPassanger() {
        new Passenger("1234","Angel","abc");
    }

    Passenger pasajero = new Passenger("1234","Angel","EE");

    @Test
    @DisplayName("Obtención del identificador")
    void passengerIdentificador() {
        Assertions.assertEquals("1234", pasajero.getIdentifier());
    }

    @Test
    @DisplayName("Obtención del nombre")
    void passengerName() {
        Assertions.assertEquals("Angel", pasajero.getName());
    }

    @Test
    @DisplayName("Obtención del código del país")
    void passengerCountry() {
        Assertions.assertEquals("EE", pasajero.getCountryCode());
    }

    @Test
    @DisplayName("Formateo de los datos a cadena")
    void passengerFlight() {
        Assertions.assertEquals("Passenger Angel with identifier: 1234 from EE", pasajero.toString());
    }
}
