package com.stoom.teste.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stoom.teste.exception.NotFoundException;
import com.stoom.teste.model.Endereco;
import com.stoom.teste.model.EnderecoDTO;
import com.stoom.teste.repository.EnderecoRepository;
import com.stoom.teste.templates.EnderecoDTOTemplate;
import com.stoom.teste.templates.EnderecoTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoServiceImplTest {
    @InjectMocks
    private EnderecoServiceImpl enderecoService;

    @Mock
    private EnderecoRepository enderecoRepository;

    private EnderecoDTOTemplate enderecoDTOTemplate = new EnderecoDTOTemplate();
    private BindingResult result = mock(BindingResult.class);

    @Before
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("com.stoom.teste.templates");
    }

    @Test
    public void mustCreate() throws JsonProcessingException {
        //given
        EnderecoDTO enderecoDTO = enderecoDTOTemplate.getEnderecoDTO();

        when(enderecoRepository.save(Mockito.any(Endereco.class))).thenAnswer(i -> i.getArguments()[0]);

        //when
        EnderecoDTO enderecoDTOResult = enderecoService.create(enderecoDTO, result);

        //then
        Assert.assertEquals(enderecoDTO, enderecoDTOResult);
        verify(enderecoRepository, times(1)).save(any(Endereco.class));
    }

    @Test
    public void mustGet() {
        //given
        Long id = 1L;
        Endereco endereco = Fixture.from(Endereco.class).gimme(EnderecoTemplate.VALIDO);
        EnderecoDTO enderecoDTO = enderecoDTOTemplate.getEnderecoDTO();

        when(enderecoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(endereco));

        //when
        EnderecoDTO enderecoFound = enderecoService.get(id);

        //then
        Assert.assertEquals(enderecoDTO, enderecoFound);
        verify(enderecoRepository, times(1)).findById(anyLong());

    }

    @Test(expected = NotFoundException.class)
    public void mustNotGet() {
        //given
        Long id = 1L;

        when(enderecoRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        //when
        EnderecoDTO enderecoFound = enderecoService.get(id);
    }

    @Test
    public void mustGetAll() {
        //given
        Endereco endereco = Fixture.from(Endereco.class).gimme(EnderecoTemplate.VALIDO);
        EnderecoDTO enderecoDTO = enderecoDTOTemplate.getEnderecoDTO();
        List<Endereco> enderecos = Collections.singletonList(endereco);
        List<EnderecoDTO> enderecoDTOS = Collections.singletonList(enderecoDTO);

        when(enderecoRepository.findAll()).thenReturn(enderecos);

        //when
        List<EnderecoDTO> enderecoFoundList = enderecoService.getAll();

        //then
        Assert.assertEquals(enderecoDTOS, enderecoFoundList);
        verify(enderecoRepository, times(1)).findAll();

    }

    @Test(expected = NotFoundException.class)
    public void mustNotGetAll() {
        //given
        List<Endereco> enderecos = Collections.emptyList();

        when(enderecoRepository.findAll())
                .thenReturn(enderecos);

        //when
        List<EnderecoDTO> enderecoFoundList = enderecoService.getAll();
    }

    @Test
    public void mustUpdateNumber() throws JsonProcessingException {
        //given
        Long id = 1L;
        Endereco endereco = Fixture.from(Endereco.class).gimme(EnderecoTemplate.VALIDO);
        EnderecoDTO enderecoDTOUpdateRequest = enderecoDTOTemplate.getEnderecoDTONumberUpdatedRequest();
        EnderecoDTO enderecoDTO = enderecoDTOTemplate.getEnderecoDTONumberUpdated();

        when(enderecoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(endereco));
        when(enderecoRepository.save(Mockito.any(Endereco.class))).thenAnswer(i -> i.getArguments()[0]);

        //when
        EnderecoDTO enderecoUpdated = enderecoService.update(id, enderecoDTOUpdateRequest, result);

        //then
        Assert.assertEquals(enderecoDTO, enderecoUpdated);
        verify(enderecoRepository, times(1)).findById(anyLong());
        verify(enderecoRepository, times(1)).save(any(Endereco.class));

    }

    @Test
    public void mustDelete() {
        //given
        Long id = 1L;
        Endereco endereco = Fixture.from(Endereco.class).gimme(EnderecoTemplate.VALIDO);
        EnderecoDTO enderecoDTO = enderecoDTOTemplate.getEnderecoDTO();

        when(enderecoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(endereco));
        doNothing().when(enderecoRepository).delete(Mockito.any(Endereco.class));

        //when
        EnderecoDTO enderecoFoundBeforeDelete = enderecoService.delete(id);

        //then
        Assert.assertEquals(enderecoDTO, enderecoFoundBeforeDelete);
        verify(enderecoRepository, times(1)).findById(anyLong());
        verify(enderecoRepository, times(1)).delete(any(Endereco.class));
    }
}