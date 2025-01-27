package com.example.busca_cep.service;

import com.example.busca_cep.dto.EnderecoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientService {
    
    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);

    private final RestTemplate restTemplate;

    // Injeção do RestTemplate no construtor
    public HttpClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EnderecoDTO getEndereco(String url) {
        logger.info("4º HttpClientService > " + url);
        return restTemplate.getForObject(url, EnderecoDTO.class);
    }

}
