package com.example.service;

import com.example.dao.PersonDao;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAll() {
        return personDao.getAll();
    }

    public Optional<Person> getById(UUID id) {
        return personDao.getById(id);
    }

    public int update(UUID id, Person newPerson) {
        return personDao.update(id, newPerson);
    }

    public void delete(UUID id) {
        personDao.delete(id);
    }
}
