package com.example.busca_cep.service;

import org.junit.jupiter.api.Assertions;

import org.mockito.Mockito;

import com.example.busca_cep.dto.EnderecoDTO;

import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ConsultaCepServiceTest {

    @InjectMocks
    private ConsultaCepService consultaCepService;

    @Mock
    private UrlCepService urlCepService;

    @Mock
    private HttpClientService httpClientService;

    @Mock
    private JsonConversionService jsonConversionService;

    @Mock
    private LogService logService;

    @Test
    void deveBuscarCepComSucesso() throws Exception {
        // Mock dos serviços auxiliares
        String cep = "12345678";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        EnderecoDTO enderecoMock = new EnderecoDTO();
        enderecoMock.setCep(cep);
        String enderecoJson = "{\"cep\":\"12345678\"}";

        Mockito.when(urlCepService.gerarUrlPorCep(cep)).thenReturn(url);
        Mockito.when(httpClientService.getEndereco(url)).thenReturn(enderecoMock);
        Mockito.when(jsonConversionService.converterParaJson(enderecoMock)).thenReturn(enderecoJson);

        // Execução do método
        EnderecoDTO endereco = consultaCepService.buscarCep(cep);

        // Verificações
        Assertions.assertNotNull(endereco);
        Assertions.assertEquals(cep, endereco.getCep());
        Mockito.verify(logService).salvarLog(url, enderecoJson, cep);
    }
}
