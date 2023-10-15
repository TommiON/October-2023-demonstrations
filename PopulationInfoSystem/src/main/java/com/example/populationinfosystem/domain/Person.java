package com.example.populationinfosystem.domain;

import com.example.populationinfosystem.utilities.Municipality;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class Person {

    @NonNull
    private PersonIdentifier identityNumber;
    @NonNull
    private String firsName;
    @NonNull
    private String lastName;
    @NonNull
    private Municipality placeOfBirth;

    private DeathDate dateOfDeath;
    private Municipality placeOfResidence;
    private ContactInfo contactInfo;

    public Person(String identifier, String firsName, String lastName, String placeOfBirth) throws Exception {
        try {
            this.identityNumber = new PersonIdentifier(identifier);
        } catch (IllegalArgumentException e) {
            throw new Exception("Henkilön luominen ei onnistu, ongelma henkilötunnuksessa");
        }

        if (firsName.isEmpty() || lastName.isEmpty()) {
            throw new Exception("Henkilön luominen ei onnistu, etu- tai sukunimi puuttuu");
        } else {
            this.firsName = firsName;
            this.lastName = lastName;
        }

        try {
            this.placeOfBirth = Municipality.valueOf(placeOfBirth.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new Exception("Henkilön luominen ei onnistu, syntymäpaikka virheellinen");
        }
    }
 }
