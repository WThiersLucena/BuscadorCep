package com.example.busca_cep.service;

import java.time.LocalDateTime;

import com.example.busca_cep.model.LogConsulta;
import com.example.busca_cep.repository.LogConsultaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);
    
    @Autowired
    private LogConsultaRepository logConsultaRepository;

    // Método para salvar log no banco de dados
    public void salvarLog(String url, String enderecoJson, String cep) {
        
        LogConsulta log = new LogConsulta(null, url, enderecoJson, LocalDateTime.now());
        log.setCep(cep);
        logger.info(" 6º salvarLog > " + enderecoJson);
        logConsultaRepository.save(log);
    }
}
