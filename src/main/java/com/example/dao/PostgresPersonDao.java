package com.example.dao;

import com.example.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PostgresPersonDao implements PersonDao{
    private final JdbcTemplate jdbcTemplate;

    public PostgresPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAll() {
        String sql = "select id, name from person";
        return jdbcTemplate.query(sql, (result, index) -> new Person(UUID.fromString(result.getString("id")), result.getString("name")));
    }

    @Override
    public Optional<Person> getById(UUID id) {
        String sql = "select id, name from person where id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[] {id}, (result, index) -> new Person(UUID.fromString(result.getString("id")), result.getString("name")));
        return Optional.ofNullable(person);
    }

    @Override
    public int update(UUID id, Person person) {
        return 0;
    }

    @Override
    public int delete(UUID id) {
        return 0;
    }
}
