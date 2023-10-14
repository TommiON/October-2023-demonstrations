package com.example.populationinfosystem.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonIdentifierTest {

    PersonIdentifier dummy;

    @BeforeEach
    public void init() {
        this.dummy = new PersonIdentifier();
    }

    @Test
    public void valids() {
        String valid = "170303-4987";
        assertTrue(dummy.set(valid));
        assertNotNull(dummy.get());

        String valid2 = "070885-368S";
        assertTrue(dummy.set(valid2));
        assertNotNull(dummy.get());
    }

    @Test
    public void tooShort() {
        String tooShort = "170303-498";
        assertFalse(dummy.set(tooShort));
        assertNull(dummy.get());
    }

    @Test
    public void tooLong() {
        String tooLong = "170303-49891";
        assertFalse(dummy.set(tooLong));
        assertNull(dummy.get());
    }

    @Test
    public void wrongMiddlePart() {
        String wrongInTheMiddle = "170303X4987";
        assertFalse(dummy.set(wrongInTheMiddle));
        assertNull(dummy.get());
    }

    @Test
    public void nonDigitsInWrongPlaces() {
        String wrongInTheBeginning = "1A0303-4987";
        assertFalse(dummy.set(wrongInTheBeginning));
        assertNull(dummy.get());

        String wrongInTheEnd = "170303-A987";
        assertFalse(dummy.set(wrongInTheEnd));
        assertNull(dummy.get());
    }

    @Test
    public void checkCharDoesNotMatch() {
        String xxx = "170303-4988";
        assertFalse(dummy.set(xxx));
        assertNull(dummy.get());

        String yyy = "070885-368K";
        assertFalse(dummy.set(yyy));
        assertNull(dummy.get());
    }

}