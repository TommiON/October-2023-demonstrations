package com.example.populationinfosystem.domain;

import com.example.populationinfosystem.utilities.Municipality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void addValidPerson() {
        String firstName = "Testi";
        String lastName = "Testinen";
        String identifier = "170303-4987";
        String placeOfBirth = "Helsinki";

        try {
            Person person = new Person(identifier, firstName, lastName, placeOfBirth);
            assertNotNull(person);
            assertEquals("Testi", person.getFirsName());
            assertEquals("Testinen", person.getLastName());
            assertEquals("170303-4987", person.getIdentityNumber().toString());
            assertEquals(Municipality.HELSINKI, person.getPlaceOfBirth());
        } catch (Exception e) { }
    }

    @Test
    public void addPersonWithInvalidBirthPlace() {
        String firstName = "Testi";
        String lastName = "Testinen";
        String identifier = "170303-4987";
        String placeOfBirth = "Perävintturi"; // ei löydy enumista

        Exception e = assertThrows(Exception.class, () -> {
            Person person = new Person(identifier, firstName, lastName, placeOfBirth);
        });
        assertTrue(e.getMessage().contains("Henkilön luominen ei onnistu, syntymäpaikka virheellinen"));
    }

    @Test
    public void addPersonWithNoName() {
        String firstName = "";
        String lastName = "Testinen";
        String identifier = "170303-4987";
        String placeOfBirth = "Helsinki";

        Exception e = assertThrows(Exception.class, () -> {
            Person person = new Person(identifier, firstName, lastName, placeOfBirth);
        });
        assertTrue(e.getMessage().contains("Henkilön luominen ei onnistu, etu- tai sukunimi puuttuu"));

        String firstName2 = "Testi";
        String lastName2 = "";
        String identifier2 = "170303-4987";
        String placeOfBirth2 = "Helsinki";

        Exception e2 = assertThrows(Exception.class, () -> {
            Person person = new Person(identifier2, firstName2, lastName2, placeOfBirth2);
        });
        assertTrue(e2.getMessage().contains("Henkilön luominen ei onnistu, etu- tai sukunimi puuttuu"));
    }

    @Test
    public void addPersonWithInvalidIdentifier() {
        String firstName = "Testi";
        String lastName = "Testinen";
        String identifier = "170303-498A";
        String placeOfBirth = "Helsinki";

        Exception e = assertThrows(Exception.class, () -> {
            Person person = new Person(identifier, firstName, lastName, placeOfBirth);
        });
        assertTrue(e.getMessage().contains("Henkilön luominen ei onnistu, ongelma henkilötunnuksessa"));
    }
}
