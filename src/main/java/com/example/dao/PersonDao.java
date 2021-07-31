package com.example.dao;

import com.example.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        return insertPerson(UUID.randomUUID(), person);
    }

    List<Person> getAll();

    Optional<Person> getById(UUID id);

    int update(UUID id, Person person);

    int delete(UUID id);
}
