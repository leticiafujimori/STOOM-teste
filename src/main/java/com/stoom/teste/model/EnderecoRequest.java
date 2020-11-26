package com.stoom.teste.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EnderecoRequest {

    @NotBlank(message = "street_name may not be blank")
    @JsonProperty(value = "street_name")
    private String streetName;

    @NotNull(message = "number may not be null")
    @JsonProperty(value = "number")
    private Integer number;

    @JsonProperty(value = "complement")
    private String complement;

    @NotBlank(message = "neighbourhood may not be blank")
    private String neighbourhood;

    @NotBlank(message = "city may not be blank")
    @JsonProperty(value = "city")
    private String city;

    @NotBlank(message = "state may not be blank")
    @JsonProperty(value = "state")
    private String state;

    @NotBlank(message = "country may not be blank")
    @JsonProperty(value = "country")
    private String country;

    @NotBlank(message = "zipcode may not be blank")
    @JsonProperty(value = "zipcode")
    private String zipcode;

    @JsonProperty(value = "latitude")
    private String latitude;

    @JsonProperty(value = "longitude")
    private String longitude;
}
