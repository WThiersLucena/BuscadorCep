package com.example.busca_cep.service;

import com.example.busca_cep.dto.EnderecoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JsonConversionService {
    
    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);
    
    private final ObjectMapper objectMapper;
    
    public JsonConversionService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Método para converter o objeto EnderecoDTO em JSON
    public String converterParaJson(EnderecoDTO endereco) throws Exception {
        logger.info(" 5º converterParaJson > " + objectMapper.writeValueAsString(endereco));
        return objectMapper.writeValueAsString(endereco);
    }
}
