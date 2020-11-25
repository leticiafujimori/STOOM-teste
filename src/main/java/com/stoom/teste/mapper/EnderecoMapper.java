package com.stoom.teste.mapper;

import com.stoom.teste.model.Endereco;
import com.stoom.teste.model.EnderecoDTO;
import com.stoom.teste.model.EnderecoRequest;
import com.stoom.teste.model.EnderecoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EnderecoMapper {

    EnderecoDTO toDTOFromModel(Endereco endereco);

    Endereco toModelFromDTO(EnderecoDTO enderecoDTO);

    EnderecoResponse toResponseFromDTO(EnderecoDTO enderecoDTO);

    EnderecoDTO toDTOFromRequest(EnderecoRequest enderecoRequest);

    List<EnderecoDTO> toDTOsFromModels(List<Endereco> enderecos);

    List<EnderecoResponse> toResponsesFromDTOs(List<EnderecoDTO> enderecoDTOS);

}
