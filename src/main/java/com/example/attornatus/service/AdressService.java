package com.example.attornatus.service;

import com.example.attornatus.model.Adress;
import com.example.attornatus.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public Adress saveOrUpdate(Adress address) {
        return adressRepository.save(address);
    }

    public List<Adress> listAdress() {
        return adressRepository.findAll();
    }

    public Optional<Adress> findAdressById(Long id) {
        return adressRepository.findById(id);
    }

    public void removeById(Long id) {
        adressRepository.deleteById(id);
    }
}
