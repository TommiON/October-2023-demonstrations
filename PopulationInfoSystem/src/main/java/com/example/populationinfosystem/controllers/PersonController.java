package com.example.populationinfosystem.controllers;

import com.example.populationinfosystem.domain.Person;
import com.example.populationinfosystem.domain.PersonIdentifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/persons")
@RestController
public class PersonController {

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonForId(@PathVariable Long id) {
        return null;
    }

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonForPersonIdentifier(@RequestParam PersonIdentifier identifier) {
        return null;
    }

    @GetMapping( value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersonsForName(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName ) {
        return null;
    }

    // POST ja PUT, mutta ei DELETE
}
