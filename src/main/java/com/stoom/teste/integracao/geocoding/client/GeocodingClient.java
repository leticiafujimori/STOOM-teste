package com.stoom.teste.integracao.geocoding.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stoom.teste.integracao.geocoding.contratos.response.GeocodingResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeocodingClient {

    public GeocodingResponse buscarInformacoesAcoes(String address, String key) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        final String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + key;

        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);


        GeocodingResponse geocodingResponse = mapper.readValue(response, GeocodingResponse.class);

        return geocodingResponse;

    }
}