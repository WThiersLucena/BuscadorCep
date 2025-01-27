package com.example.busca_cep.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import com.example.busca_cep.repository.LogConsultaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

@ExtendWith(MockitoExtension.class)
public class LogServiceTest {

    @Mock
    private LogConsultaRepository logConsultaRepository;

    @Mock
    private Logger logger;

    @InjectMocks
    private LogService logService;

    @Test
    public void testSalvarLogComUrlNull() {

        String url = null;
        String enderecoJson = "{\"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\", \"complemento\": \"\", \"bairro\": \"Sé\", \"localidade\": \"São Paulo\", \"uf\": \"SP\", \"ibge\": \"3550308\", \"gia\": \"1004\", \"ddd\": \"11\", \"siafi\": \"7107\"}";
        String cep = "01001-000";

        assertDoesNotThrow(() -> logService.salvarLog(url, enderecoJson, cep));
    }

    @Test
    public void testSalvarLogComEnderecoJsonNull() {

        String url = "https://viacep.com.br/ws/01001-000/json/";
        String enderecoJson = null;
        String cep = "01001-000";

        assertDoesNotThrow(() -> logService.salvarLog(url, enderecoJson, cep));
    }

    @Test
    public void testSalvarLogComCepNull() {

        String url = "https://viacep.com.br/ws/01001-000/json/";
        String enderecoJson = "{\"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\", \"complemento\": \"\", \"bairro\": \"Sé\", \"localidade\": \"São Paulo\", \"uf\": \"SP\", \"ibge\": \"3550308\", \"gia\": \"1004\", \"ddd\": \"11\", \"siafi\": \"7107\"}";
        String cep = null;

        assertDoesNotThrow(() -> logService.salvarLog(url, enderecoJson, cep));
    }
}
