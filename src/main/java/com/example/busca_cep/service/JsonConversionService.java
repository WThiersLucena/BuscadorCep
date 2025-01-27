package com.example.busca_cep.service;

import com.example.busca_cep.dto.EnderecoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

@Service
public class JsonConversionService {
    
    
    private final ObjectMapper objectMapper;
    
    public JsonConversionService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Método para converter o objeto EnderecoDTO em JSON
    public String converterParaJson(EnderecoDTO endereco) throws Exception {
        return objectMapper.writeValueAsString(endereco);
    }
}
