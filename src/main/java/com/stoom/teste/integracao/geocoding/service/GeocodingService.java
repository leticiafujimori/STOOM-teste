package com.stoom.teste.integracao.geocoding.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stoom.teste.integracao.geocoding.client.GeocodingClient;
import com.stoom.teste.integracao.geocoding.contratos.response.GeocodingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeocodingService {

    @Value("${geocoding.apikey}")
    private String apikey;

    @Autowired
    GeocodingClient geocodingClient;

    public GeocodingResponse findLatitudeAndLongitude(String enderecoFormatado) throws JsonProcessingException {
        GeocodingResponse geocodingResponse = geocodingClient.buscarInformacoesAcoes(enderecoFormatado, apikey);

        return  geocodingResponse;
    }
}
