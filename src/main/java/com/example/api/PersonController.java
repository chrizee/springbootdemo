package com.example.api;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/Person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Validated @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping(path = "{id}")
    public Person getById(@PathVariable("id")UUID id) {
        return personService.getById(id).orElse(null);
    }

    @PutMapping("{id}")
    public int update(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Person newPerson) {
        return personService.update(id, newPerson);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") UUID id) {
        personService.delete(id);
    }
}
