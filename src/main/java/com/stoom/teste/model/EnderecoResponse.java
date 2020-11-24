package com.stoom.teste.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnderecoResponse {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "street_name")
    private String streetName;

    @JsonProperty(value = "number")
    private Integer number;

    @JsonProperty(value = "complement")
    private String complement;

    @JsonProperty(value = "neighbourhood")
    private String neighbourhood;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "state")
    private String state;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "zipcode")
    private String zipcode;

    @JsonProperty(value = "latitude")
    private String latitude;

    @JsonProperty(value = "longitude")
    private String longitude;
}
