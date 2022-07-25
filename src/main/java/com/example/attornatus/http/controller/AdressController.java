package com.example.attornatus.http.controller;

import com.example.attornatus.model.Adress;
import com.example.attornatus.service.AdressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressController {


    @Autowired
    private AdressService adressService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Adress saveOrUpdate(@RequestBody Adress adress) {
        return adressService.saveOrUpdate(adress);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Adress> listAdress() {
        return adressService.listAdress();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Adress findAdressById(@PathVariable("id") Long id) {
        return adressService.findAdressById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_EXTENDED,
                        "Adress not found."));
    }

    @DeleteMapping("/{id}")
    public void removeAdress(@PathVariable("id") Long id) {
        adressService.findAdressById(id)
                .map(adress -> {
                    adressService.removeById(adress.getId());
                    return Void.TYPE;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAdress(@PathVariable("id") Long id, @RequestBody Adress adress) {
        adressService.findAdressById(id)
                .map(baseAdress -> {
                    modelMapper.map(adress, baseAdress);
                    adressService.saveOrUpdate(baseAdress);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Adress not found."));
    }
}
