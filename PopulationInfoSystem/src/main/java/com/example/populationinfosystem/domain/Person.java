package com.example.populationinfosystem.domain;

import lombok.Data;
import lombok.NonNull;


@Data
public class Person {

    @NonNull
    private PersonIdentifier identityNumber;

    @NonNull
    private String firsName;

    @NonNull
    private String lastName;

    @NonNull
    private CalendarDate dateOfBirth;

    private CalendarDate dateOfDeath;

    @NonNull
    private Municipality placeOfBirth;

    private Municipality placeOfResidence;

    private ContactInfo contactInfo;
}
