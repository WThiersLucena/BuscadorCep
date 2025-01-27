package com.example.busca_cep.service;

import com.example.busca_cep.dto.EnderecoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class JsonConversionServiceTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private JsonConversionService jsonConversionService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveConverterParaJsonComSucesso() throws Exception {
        
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setCep("12345678");
        enderecoDTO.setLogradouro("Rua Exemplo");
        enderecoDTO.setBairro("Bairro Exemplo");
        enderecoDTO.setLocalidade("Cidade Exemplo");
        enderecoDTO.setUf("Estado Exemplo");

        String enderecoJson = "{\"cep\":\"12345678\",\"logradouro\":\"Rua Exemplo\",\"bairro\":\"Bairro Exemplo\",\"cidade\":\"Cidade Exemplo\",\"estado\":\"Estado Exemplo\"}";

        Mockito.when(objectMapper.writeValueAsString(enderecoDTO)).thenReturn(enderecoJson);

        
        String resultado = jsonConversionService.converterParaJson(enderecoDTO);

        
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(enderecoJson, resultado);
        Mockito.verify(objectMapper).writeValueAsString(enderecoDTO);
    }

    @Test
    void deveLancarExcecaoAoConverterParaJson() throws JsonProcessingException {

        
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        Mockito.when(objectMapper.writeValueAsString(enderecoDTO))
                .thenThrow(new RuntimeException("Erro ao converter para JSON"));

        
        Exception exception = Assertions.assertThrows(Exception.class,
                () -> jsonConversionService.converterParaJson(enderecoDTO));
        Assertions.assertEquals("Erro ao converter para JSON", exception.getMessage());
        Mockito.verify(objectMapper).writeValueAsString(enderecoDTO);
    }

}
