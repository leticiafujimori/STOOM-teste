package com.stoom.teste.mapper;

import com.stoom.teste.integracao.geocoding.contratos.response.GeocodingResponse;
import com.stoom.teste.model.EnderecoDTO;
import org.springframework.stereotype.Component;

@Component
public class GeocodingMapper {
    public String toAddressFormated(EnderecoDTO enderecoDTO) {
        String addressFormated = enderecoDTO.getNumber()
                + "+" + formatString(enderecoDTO.getStreetName())
                + ",+" + formatString(enderecoDTO.getNeighbourhood())
                + ",+" + formatString(enderecoDTO.getCity())
                + ",+" + formatString(enderecoDTO.getState())
                + ",+" + formatString(enderecoDTO.getCountry());
        System.out.println(addressFormated);
        return addressFormated;
    }

    public EnderecoDTO toEnderecoDTO(GeocodingResponse geocodingResponse, EnderecoDTO enderecoDTO) {
        return EnderecoDTO.builder()
                .id(enderecoDTO.getId())
                .streetName(enderecoDTO.getStreetName())
                .number(enderecoDTO.getNumber())
                .complement(enderecoDTO.getComplement())
                .neighbourhood(enderecoDTO.getNeighbourhood())
                .city(enderecoDTO.getCity())
                .state(enderecoDTO.getState())
                .country(enderecoDTO.getCountry())
                .zipcode(enderecoDTO.getZipcode())
                .latitude(geocodingResponse.getResults().get(0).getGeometry().getLocation().getLatitude())
                .longitude(geocodingResponse.getResults().get(0).getGeometry().getLocation().getLongitude()).build();
    }

    private String formatString(String name) {
        return name.replace(" ", "+");
    }
}


