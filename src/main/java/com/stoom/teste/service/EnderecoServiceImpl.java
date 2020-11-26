package com.stoom.teste.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stoom.teste.exception.NotFoundException;
import com.stoom.teste.exception.RequiredFieldException;
import com.stoom.teste.integracao.geocoding.service.GeocodingService;
import com.stoom.teste.mapper.EnderecoMapper;
import com.stoom.teste.mapper.GeocodingMapper;
import com.stoom.teste.model.Endereco;
import com.stoom.teste.model.EnderecoDTO;
import com.stoom.teste.repository.EnderecoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private GeocodingService geocodingService;

    @Autowired
    private GeocodingMapper geocodingMapper;

    private final EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTONew, BindingResult result) throws JsonProcessingException {
        verifyRequiredField(result);
        enderecoDTONew = fillLatitudeAndLongitude(enderecoDTONew);

        Endereco endereco = enderecoMapper.toModelFromDTO(enderecoDTONew);
        return enderecoMapper.toDTOFromModel(enderecoRepository.save(endereco));
    }

    @Override
    public EnderecoDTO get(Long id) {
        return enderecoMapper.toDTOFromModel(searchById(id));
    }

    @Override
    public List<EnderecoDTO> getAll() {
        List<Endereco> enderecosFound = enderecoRepository.findAll();
        if (enderecosFound.isEmpty()) {
            throw new NotFoundException();
        }
        return enderecoMapper.toDTOsFromModels(enderecosFound);
    }

    @Override
    public EnderecoDTO update(Long id, EnderecoDTO enderecoDTOUpdate, BindingResult result) throws JsonProcessingException {
        verifyRequiredField(result);

        enderecoDTOUpdate = fillLatitudeAndLongitude(enderecoDTOUpdate);

        Endereco enderecoFound = searchById(id);
        Endereco enderecoUpdated = enderecoMapper.toModelFromDTO(enderecoDTOUpdate);
        enderecoUpdated.setId(enderecoFound.getId());
        return enderecoMapper.toDTOFromModel(enderecoRepository.save(enderecoUpdated));
    }

    @Override
    public EnderecoDTO delete(Long id) {
        Endereco enderecoFound = searchById(id);
        enderecoRepository.delete(enderecoFound);
        return enderecoMapper.toDTOFromModel(enderecoFound);
    }

    private Endereco searchById(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    private void verifyRequiredField(BindingResult result) {
        if (result.getAllErrors().size() > 0) {
            String x = result.getAllErrors().get(0).getDefaultMessage();
            throw new RequiredFieldException(result.getAllErrors().get(0).getDefaultMessage());
        }
    }

    private EnderecoDTO fillLatitudeAndLongitude(EnderecoDTO enderecoDTO) throws JsonProcessingException {
        if (enderecoDTO.getLatitude() == null || enderecoDTO.getLatitude().isEmpty()
                || enderecoDTO.getLongitude() == null || enderecoDTO.getLongitude().isEmpty()) {
            return geocodingMapper.toEnderecoDTO(geocodingService.findLatitudeAndLongitude(geocodingMapper.toAddressFormated(enderecoDTO)), enderecoDTO);
        }
        return enderecoDTO;
    }
}
