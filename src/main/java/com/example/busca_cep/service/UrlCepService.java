package com.example.busca_cep.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;

@Service
public class UrlCepService {
    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);

    // private static final String BASE_URL = "https://viacep.com.br/ws/";

    // Método responsável por criar a URL
    // public String gerarUrlPorCep(String cep) {
    // logger.info(" 3º Criando URL > " + BASE_URL + cep + "/json/");
    // return BASE_URL + cep + "/json/";
    // }


    

    // Injetando a URL base do ambiente através de uma variável de ambiente ou
    // arquivo de configuração
    private final String baseUrl;

    // Construtor padrão para o Spring
    public UrlCepService(@Value("${api.cep.base-url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // Método responsável por criar a URL
    public String gerarUrlPorCep(String cep) {
        String url = baseUrl + cep + "/json/";
        logger.info("3º Criando URL > {}", url);
        return url;
    }

}
