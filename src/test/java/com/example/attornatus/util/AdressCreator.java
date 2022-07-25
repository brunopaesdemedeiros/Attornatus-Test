package com.example.attornatus.util;

import com.example.attornatus.model.Adress;

public class AdressCreator {

    public static Adress createToBeSavedAdress() {
        return Adress.builder().id(1l).adress("Doraci de Medeiros").
                city("Capivari").mainAdress(true).number(88).zipCode("88745-000").build();

    }

    public static Adress createValidAdress() {
        return Adress.builder().id(1l).adress("Doraci de Medeiros").
                city("Capivari").mainAdress(true).number(88).zipCode("88745-000").build();

    }

    public static Adress createUpdateAdress() {
        return Adress.builder().id(1l).adress("Doraci de Medeiros").
                city("Capivari").mainAdress(true).number(88).zipCode("88745-000").build();

    }
}
