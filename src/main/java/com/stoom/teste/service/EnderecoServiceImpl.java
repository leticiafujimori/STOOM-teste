package com.stoom.teste.service;

import com.stoom.teste.exception.NotFoundException;
import com.stoom.teste.exception.RequiredFieldException;
import com.stoom.teste.mapper.EnderecoMapper;
import com.stoom.teste.model.Endereco;
import com.stoom.teste.model.EnderecoDTO;
import com.stoom.teste.repository.EnderecoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    private final EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTONew, BindingResult result) {
        verifyRequiredField(result);

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
    public EnderecoDTO update(Long id, EnderecoDTO enderecoDTOUpdate, BindingResult result) {
        verifyRequiredField(result);

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
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    private void verifyRequiredField(BindingResult result) {
        if (result.getAllErrors().size() > 0) {
            String x = result.getAllErrors().get(0).getDefaultMessage();
            throw new RequiredFieldException(result.getAllErrors().get(0).getDefaultMessage());
        }
    }
}
