package com.example.busca_cep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
class UrlCepServiceTest {

    @Test
    void testGerarUrlPorCep() {
        UrlCepService urlCepService = new UrlCepService(null);

        String testBaseUrl = "https://test-viacep.com.br/ws/";
        // Usando ReflectionTestUtils para configurar o campo privado
        ReflectionTestUtils.setField(urlCepService, "baseUrl", testBaseUrl);

        String cep = "12345678";
        String expectedUrl = testBaseUrl + cep + "/json/";

        String result = urlCepService.gerarUrlPorCep(cep);
        assertEquals(expectedUrl, result);
    }
}
