package com.example.attornatus.util;

import com.example.attornatus.model.Person;

import java.time.LocalDate;

public class PersonCreator {


    public static Person createToBeSavedPerson() {
        return Person.builder().name("Bruno").
                birthDate(LocalDate.of(1989, 12, 18)).build();

    }

    public static Person createValidPerson() {
        return Person.builder().id(1L).name("Bruno").
                birthDate(LocalDate.of(1989, 12, 18)).build();

    }

    public static Person createUpdatePerson() {
        return Person.builder().id(1L).name("João").
                birthDate(LocalDate.of(1995, 10, 12)).build();

    }
}


