package com.example.populationinfosystem.controllers;

import com.example.populationinfosystem.domain.ContactInfo;
import com.example.populationinfosystem.domain.Person;
import com.example.populationinfosystem.domain.PersonIdentifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/persons")
@RestController
public class PersonController {

    // hakisi järjestelmän sisäisellä (tietokanta)id:llä jos sellainen olisi toteutettu
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person getPersonForId(@PathVariable Long id) {
         return null;
    }

    // haku henkilötunnuksella
    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person getPersonForPersonIdentifier(@RequestBody PersonIdentifier identifier) {
        return null;
    }

    // uuden henkilön lisäys
    @PostMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person addPerson(@RequestBody Person personalData) {
        return null;
    }

    // Ei PUT-metodeita pakollisille attribuuteille, oletuksena että eivät muutu
    // EI DELETE-metodia Personille, oletuksena että kukaan ei koskaan poistu rekisteristä

    // yhteystietojen lisäys
    @PostMapping(value="/{id}/contactinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person addContactInfo(@PathVariable Long id, @RequestBody ContactInfo contactInfo) {
        return null;
    }

    // yhteystietojen päivitys
    @PutMapping(value="/{id}/contactinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person updateContactInfo(@PathVariable Long id, @RequestBody ContactInfo contactInfo) {
        return null;
    }
}
