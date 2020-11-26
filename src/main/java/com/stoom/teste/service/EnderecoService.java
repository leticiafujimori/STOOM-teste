package com.stoom.teste.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stoom.teste.model.EnderecoDTO;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface EnderecoService {

    EnderecoDTO create(EnderecoDTO enderecoDTONew, BindingResult result) throws JsonProcessingException;

    EnderecoDTO get(Long id);

    List<EnderecoDTO> getAll();

    EnderecoDTO update(Long id, EnderecoDTO enderecoDTOUpdate, BindingResult result) throws JsonProcessingException;

    EnderecoDTO delete(Long id);
}
