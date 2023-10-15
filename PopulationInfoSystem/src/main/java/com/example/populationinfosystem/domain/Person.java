package com.example.populationinfosystem.domain;

import com.example.populationinfosystem.utilities.Municipality;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Data
public class Person {

    // pakolliset perustiedot, vaaditaan uutta Personia luotaessa
    @NonNull
    private PersonIdentifier identityNumber;
    @NonNull
    private String firsName;
    @NonNull
    private String lastName;
    @NonNull
    private Municipality placeOfBirth;

    // ei-pakolliset lisätiedot, asetettaisiin luomisen jälkeen erillisillä settereillä
    private Municipality placeOfResidence;
    private ContactInfo contactInfo;
    private DeathDate dateOfDeath;

    // sukulaisuussuhteet
    private Person father;
    private Person mother;
    private Person spouse; // jos tarvitaan tieto avioliiton päivämäärästä jne, tämä ei riitä
    private List<Person> offspring; // ainoastaan viite, syntymäaika ja muut tiedot haetaan tarvittaessa lapsiobjektilta

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

    // tänne erilaisia metodeita kuolemiseen, yhteystietojen lisäämiseen/päivittämiseen jne.

 }
