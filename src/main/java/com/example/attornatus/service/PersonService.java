package com.example.attornatus.service;

import com.example.attornatus.model.Person;
import com.example.attornatus.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person saveOrUpdate(Person person) {
        return personRepository.save(person);
    }

    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public void removeById(Long id) {
        personRepository.deleteById(id);
    }
}
