package com.example.attornatus.repository;

import com.example.attornatus.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
