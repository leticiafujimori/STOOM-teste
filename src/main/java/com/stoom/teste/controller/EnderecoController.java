package com.stoom.teste.controller;

import com.stoom.teste.mapper.EnderecoMapper;
import com.stoom.teste.model.EnderecoDTO;
import com.stoom.teste.model.EnderecoRequest;
import com.stoom.teste.model.EnderecoResponse;
import com.stoom.teste.model.MessageResponse;
import com.stoom.teste.service.EnderecoServiceImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    private final EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);

    @PostMapping("create")
    public ResponseEntity<MessageResponse> createMethod(@RequestBody @Valid EnderecoRequest enderecoRequest, BindingResult result) {
        EnderecoDTO enderecoDTO = enderecoMapper.toDTOFromRequest(enderecoRequest);

        EnderecoResponse enderecoResponse = enderecoMapper.toResponseFromDTO(enderecoService.create(enderecoDTO, result));

        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Register created successfully! Id " + enderecoResponse.getId()));
    }

    @GetMapping("get")
    public ResponseEntity<EnderecoResponse> getMethod(@RequestParam Long id) {
        EnderecoResponse enderecoResponse = enderecoMapper.toResponseFromDTO(enderecoService.get(id));

        return ResponseEntity.status(HttpStatus.OK).body(enderecoResponse);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<EnderecoResponse>> getAllMethod() {
        List<EnderecoResponse> enderecosResponse = enderecoMapper.toResponsesFromDTOs(enderecoService.getAll());

        return ResponseEntity.status(HttpStatus.OK).body(enderecosResponse);
    }

    @PutMapping("update")
    public ResponseEntity<MessageResponse> updateMethod(@RequestParam Long id, @RequestBody EnderecoRequest enderecoRequest, BindingResult result) {
        EnderecoDTO enderecoDTO = enderecoMapper.toDTOFromRequest(enderecoRequest);

        EnderecoResponse enderecoResponse = enderecoMapper.toResponseFromDTO(enderecoService.update(id, enderecoDTO, result));

        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Register with id " + enderecoResponse.getId() + " updated successfully!"));
    }

    @DeleteMapping("delete")
    public ResponseEntity<MessageResponse> deleteMethod(@RequestParam Long id) {
        EnderecoResponse enderecoResponse = enderecoMapper.toResponseFromDTO(enderecoService.delete(id));

        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Register with id " + enderecoResponse.getId() + " deleted successfully!"));
    }
}
