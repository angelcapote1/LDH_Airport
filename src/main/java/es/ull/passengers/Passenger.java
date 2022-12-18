/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.flights.Flight;

public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    /**
     * Constructor de la clase pasajeros
     * @param identifier
     * @param name
     * @param countryCode
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     * @return retorna el identificador del pasajero
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return Retorna el nombre del pasajero
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return Retorna el pais de procedencia de l pasajero
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @return Retorna el vuelo al que pertenece el pasajero
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Se añade el pasajero al vuelo indicado
     * @param flight vuelo
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     * Se le asigna un vuelo al pasajero
     * @param flight vuelo
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
