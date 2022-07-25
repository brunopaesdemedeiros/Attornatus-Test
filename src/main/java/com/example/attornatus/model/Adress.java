package com.example.attornatus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Adress implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adress")
    private String adress;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "number")
    private int number;

    @Column(name = "city")
    private String city;

    @Column(name = "mainAdress", nullable = false)
    private boolean mainAdress;


}
