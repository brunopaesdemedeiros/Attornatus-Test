package com.example.attornatus.repository;

import com.example.attornatus.model.Person;
import com.example.attornatus.util.PersonCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Person Repository")
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Test
    @DisplayName("Save persists creates person")
    void savePerson() {
        Person personToBesaved = PersonCreator.createToBeSavedPerson();
        Person personSaved = this.personRepository.save(personToBesaved);
        personRepository.save(personSaved);

        Assertions.assertThat(personSaved).isNotNull();
        Assertions.assertThat(personSaved.getId()).isNotNull();
        Assertions.assertThat(personSaved.getName()).isEqualTo(personSaved.getName());
    }

    @Test
    @DisplayName("Update persists updates person")
    void updatePerson() {
        Person personToBesaved = PersonCreator.createToBeSavedPerson();
        Person personSaved = this.personRepository.save(personToBesaved);
        personSaved.setName("João");
        Person personUpdate = this.personRepository.save(personSaved);

        Assertions.assertThat(personUpdate).isNotNull();
        Assertions.assertThat(personUpdate.getId()).isNotNull();
        Assertions.assertThat(personUpdate.getName()).isEqualTo(personSaved.getName());
    }

    @Test
    @DisplayName("Delete person")
    void deletePerson() {
        Person personToBesaved = PersonCreator.createToBeSavedPerson();
        Person personSaved = this.personRepository.save(personToBesaved);
        this.personRepository.delete(personSaved);
        Optional<Person> personOptional = this.personRepository.findById(personSaved.getId());

        Assertions.assertThat(personOptional.isEmpty());
    }

    @Test
    @DisplayName("Find by id return list of person")
    void findByIdPerson() {
        Person personToBesaved = PersonCreator.createToBeSavedPerson();
        Person personSaved = this.personRepository.save(personToBesaved);
        Optional<Person> personOptional = this.personRepository.findById(personSaved.getId());

        Assertions.assertThat(personOptional.isEmpty());
    }



}