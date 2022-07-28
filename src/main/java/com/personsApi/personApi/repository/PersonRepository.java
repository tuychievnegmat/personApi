package com.personsApi.personApi.repository;


import com.personsApi.personApi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPerosonByUsername(String username);
    Person findPersonById(Long id);
}
