package com.stoom.teste.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EnderecoDTO {
    private Long id;
    private String streetName;
    private Integer number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String latitude;
    private String longitude;
}
