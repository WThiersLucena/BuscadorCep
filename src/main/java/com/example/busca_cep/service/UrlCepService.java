package com.example.busca_cep.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UrlCepService {
    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);
    
    private static final String BASE_URL = "https://viacep.com.br/ws/";


    // Método responsável por criar a URL
    public String gerarUrlPorCep(String cep) {
        logger.info(" 3º Criando URL > " + BASE_URL + cep + "/json/");
        return BASE_URL + cep + "/json/";
    }
}
