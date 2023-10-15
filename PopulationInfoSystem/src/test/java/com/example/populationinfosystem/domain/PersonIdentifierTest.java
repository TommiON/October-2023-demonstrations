package com.example.populationinfosystem.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonIdentifierTest {

    @Test
    public void valids() {
        PersonIdentifier id1 = new PersonIdentifier("170303-4987");
        assertNotNull(id1);
        assertEquals("170303-4987", id1.toString());

        PersonIdentifier id2 = new PersonIdentifier("070885-368S");
        assertNotNull(id2);
        assertEquals("070885-368S", id2.toString());
    }

    @Test
    public void tooShort() {
        String tooShort = "170303-498";
        Exception e = assertThrows(IllegalArgumentException.class, () -> { new PersonIdentifier(tooShort); });
        assertTrue(e.getMessage().contains("Henkilötunnus ei ole validi"));
    }

    @Test
    public void tooLong() {
        String tooLong = "170303-49891";
        Exception e = assertThrows(IllegalArgumentException.class, () -> { new PersonIdentifier(tooLong); });
        assertTrue(e.getMessage().contains("Henkilötunnus ei ole validi"));
    }

    @Test
    public void wrongMiddlePart() {
        String wrongInTheMiddle = "170303X4987";
        Exception e = assertThrows(IllegalArgumentException.class, () -> { new PersonIdentifier(wrongInTheMiddle); });
        assertTrue(e.getMessage().contains("Henkilötunnus ei ole validi"));
    }

    @Test
    public void nonDigitsInWrongPlaces() {
        String wrongInTheBeginning = "1A0303-4987";
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> { new PersonIdentifier(wrongInTheBeginning); });
        assertTrue(e1.getMessage().contains("Henkilötunnus ei ole validi"));

        String wrongInTheEnd = "170303-A987";
        Exception e2 = assertThrows(IllegalArgumentException.class, () -> { new PersonIdentifier(wrongInTheEnd); });
        assertTrue(e2.getMessage().contains("Henkilötunnus ei ole validi"));
    }

    @Test
    public void checkCharDoesNotMatch() {
        String xxx = "170303-4988";
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> { new PersonIdentifier(xxx); });
        assertTrue(e1.getMessage().contains("Henkilötunnus ei ole validi"));

        String yyy = "070885-368K";
        Exception e2 = assertThrows(IllegalArgumentException.class, () -> { new PersonIdentifier(yyy); });
        assertTrue(e2.getMessage().contains("Henkilötunnus ei ole validi"));
    }

}