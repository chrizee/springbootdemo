package com.example.dao;

import com.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("memory")
public class MemoryPersonDao implements PersonDao {

    private static List<Person> Db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        Db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAll() {
        return Db;
    }

    @Override
    public Optional<Person> getById(UUID id) {
        return Db.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public int update(UUID id, Person person) {
        return getById(id)
                .map(p -> {
                    int index = Db.indexOf(p);
                    if(index >= 0) {
                        Db.set(index, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }

    @Override
    public int delete(UUID id) {
        Optional<Person> personMaybe = getById(id);
        if(personMaybe.isEmpty()) return 0;
        Db.remove(personMaybe.get());
        return 1;
    }
}
