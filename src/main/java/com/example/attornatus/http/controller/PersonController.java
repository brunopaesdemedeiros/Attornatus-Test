package com.example.attornatus.http.controller;

import com.example.attornatus.model.Person;
import com.example.attornatus.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person saveOrUpdate(@RequestBody Person person) {
        return personService.saveOrUpdate(person);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> listPerson() {
        return personService.listPerson();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person findPersonById(@PathVariable("id") Long id) {
        return personService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_EXTENDED,
                        "Person not found."));
    }

    @DeleteMapping("/{id}")
    public void removePerson(@PathVariable("id") Long id) {
        personService.findById(id)
                .map(person -> {
                    personService.removeById(person.getId());
                    return Void.TYPE;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        personService.findById(id)
                .map(BasePerson -> {
                    modelMapper.map(person, BasePerson);
                    personService.saveOrUpdate(BasePerson);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Person not found."));
    }
}
