package com.example.busca_cep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.busca_cep.dto.EnderecoDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

public class HttpClientServiceTest {

    @InjectMocks
    private HttpClientService httpClientService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEndereco() {
        // Arrange
        String url = "http://fake-url.com/cep/12345678";

        EnderecoDTO mockEndereco = new EnderecoDTO();
        mockEndereco.setCep("12345678");
        mockEndereco.setLogradouro("Rua Exemplo");
        mockEndereco.setBairro("Bairro Exemplo");
        mockEndereco.setLocalidade("Cidade Exemplo");
        mockEndereco.setUf("Estado Exemplo");

        // Configurando o mock do RestTemplate
        when(restTemplate.getForObject(url, EnderecoDTO.class)).thenReturn(mockEndereco);

        // Act
        EnderecoDTO result = httpClientService.getEndereco(url);

        // Assert
        assertNotNull(result);
        assertEquals("12345678", result.getCep());
        assertEquals("Rua Exemplo", result.getLogradouro());
        assertEquals("Bairro Exemplo", result.getBairro());
        assertEquals("Cidade Exemplo", result.getLocalidade());
        assertEquals("Estado Exemplo", result.getUf());

        // Verificando se o RestTemplate foi chamado corretamente
        verify(restTemplate, times(1)).getForObject(url, EnderecoDTO.class);
    }

}
