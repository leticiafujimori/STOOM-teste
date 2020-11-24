package com.stoom.teste.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private Integer number;

    @Column
    private String complement;

    @Column(nullable = false)
    private String neighbourhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String zipcode;

    @Column
    private String latitude;

    @Column
    private String longitude;
}
