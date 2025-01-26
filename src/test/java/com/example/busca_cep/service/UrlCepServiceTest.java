package com.example.busca_cep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UrlCepServiceTest {
    
    private UrlCepService urlCepService = new UrlCepService();

    @Test
    public void testGerarUrlPorCep() {
        // Arrange
        String cep = "01001-000";

        // Act
        String urlGerada = urlCepService.gerarUrlPorCep(cep);

        // Assert
        String urlEsperada = "https://viacep.com.br/ws/01001-000/json/";
        assertEquals(urlEsperada, urlGerada);
    }

    @Test
    public void testGerarUrlPorCepComCepInvalido() {
        // Arrange
        String cep = "123456789";

        // Act
        String urlGerada = urlCepService.gerarUrlPorCep(cep);

        // Assert
        String urlEsperada = "https://viacep.com.br/ws/123456789/json/";
        assertEquals(urlEsperada, urlGerada);
    }
 

    @Test
    public void testGerarUrlPorCepComCepVazio() {
        // Arrange
        String cep = "";

        // Act
        String urlGerada = urlCepService.gerarUrlPorCep(cep);

        // Assert
        String urlEsperada = "https://viacep.com.br/ws//json/";
        assertEquals(urlEsperada, urlGerada);
    }
}
