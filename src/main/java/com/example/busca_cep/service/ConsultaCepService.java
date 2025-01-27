package com.example.busca_cep.service;

import com.example.busca_cep.dto.EnderecoDTO;
import com.example.busca_cep.exception.CepNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaCepService {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);

    @Autowired
    private UrlCepService urlCepService; 

    @Autowired
    private JsonConversionService jsonConversionService; 

    @Autowired
    private LogService logService;

    @Autowired
    private HttpClientService httpClientService;

    public EnderecoDTO buscarCep(String cep) throws Exception {
        logger.info(" 2º Service > Buscando informacoes para o CEP: {}", cep);
        try {

            String url = urlCepService.gerarUrlPorCep(cep);

            EnderecoDTO endereco = httpClientService.getEndereco(url);

            if (endereco != null && endereco.getCep() != null) {
                String enderecoJson = jsonConversionService.converterParaJson(endereco);

                logService.salvarLog(url, enderecoJson, cep);

                return endereco;
            } else {
                throw new CepNotFoundException("CEP não encontrado ou resposta inválida.");
            }
        } catch (CepNotFoundException e) {

            logger.error("Erro ao buscar CEP: {}", e.getMessage());
            throw e;
        } catch (Exception e) {

            logger.error("Erro inesperado ao buscar CEP: {}", e.getMessage());
            throw new RuntimeException("Erro ao buscar CEP: " + e.getMessage());
        }

    }

}
