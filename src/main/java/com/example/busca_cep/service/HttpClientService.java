package com.example.busca_cep.service;

import com.example.busca_cep.dto.EnderecoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientService {
    
    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);

    public EnderecoDTO getEndereco(String url) {
        
        RestTemplate restTemplate = new RestTemplate();
        logger.info(" 4º HttpClientService > " + url, EnderecoDTO.class);
        return restTemplate.getForObject(url, EnderecoDTO.class);
    }
    
}
