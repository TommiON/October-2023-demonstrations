package com.example.populationinfosystem.domain;

import com.example.populationinfosystem.utilities.Municipality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void addValidPerson() {
        String firsName = "Testi";
        String lastName = "Testinen";
        String identifier = "170303-4987";
        String placeOfBirth = "Helsinki";

        try {
            Person person = new Person(identifier, firsName, lastName, placeOfBirth);
            assertNotNull(person);
            assertEquals("Testi", person.getFirsName());
            assertEquals("Testinen", person.getLastName());
            assertEquals("170303-4987", person.getIdentityNumber().toString());
            assertEquals(Municipality.HELSINKI, person.getPlaceOfBirth());
        } catch (Exception e) {}
    }

    @Test
    public void addPersonWithInvalidBirthPlace() {
        String firsName = "Testi";
        String lastName = "Testinen";
        String identifier = "170303-4987";
        String placeOfBirth = "Perävintturi"; // ei löydy enumista

        Exception e = assertThrows(Exception.class, () -> { Person person = new Person(identifier, firsName, lastName, placeOfBirth); });
        assertTrue(e.getMessage().contains("Henkilön luominen ei onnistu, syntymäpaikka virheellinen"));
    }

}