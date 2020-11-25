package com.stoom.teste.templates;

import com.stoom.teste.model.EnderecoDTO;

public class EnderecoDTOTemplate {
    public EnderecoDTO enderecoDTO = EnderecoDTO.builder()
            .id(1L)
            .streetName("Nome da rua")
            .number(1234)
            .complement("Complemento")
            .neighbourhood("Bairro")
            .city("Cidade")
            .state("Estado")
            .country("País")
            .zipcode("12345-678")
            .latitude("Latitude")
            .longitude("Longitude")
            .build();

    public EnderecoDTO enderecoDTONumberUpdatedRequest = EnderecoDTO.builder()
            .streetName("Nome da rua")
            .number(567)
            .complement("Complemento")
            .neighbourhood("Bairro")
            .city("Cidade")
            .state("Estado")
            .country("País")
            .zipcode("12345-678")
            .latitude("Latitude")
            .longitude("Longitude")
            .build();

    public EnderecoDTO enderecoDTONumberUpdated = EnderecoDTO.builder()
            .id(1L)
            .streetName("Nome da rua")
            .number(567)
            .complement("Complemento")
            .neighbourhood("Bairro")
            .city("Cidade")
            .state("Estado")
            .country("País")
            .zipcode("12345-678")
            .latitude("Latitude")
            .longitude("Longitude")
            .build();

    public EnderecoDTO getEnderecoDTO(){
        return enderecoDTO;
    }

    public EnderecoDTO getEnderecoDTONumberUpdatedRequest(){
        return enderecoDTONumberUpdatedRequest;
    }

    public EnderecoDTO getEnderecoDTONumberUpdated(){
        return enderecoDTONumberUpdated;
    }

}
