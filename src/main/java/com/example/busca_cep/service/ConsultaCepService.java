package com.example.busca_cep.service;


import com.example.busca_cep.dto.EnderecoDTO;
import com.example.busca_cep.exception.CepNotFoundException;
import com.example.busca_cep.repository.LogConsultaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaCepService {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepService.class);

    @Autowired
    private LogConsultaRepository logConsultaRepository;

    @Autowired
    private ObjectMapper objectMapper; // Jackson para conversão de objetos em JSON

    // SOLID
    @Autowired
    private UrlCepService urlCepService; // Injetando o novo serviço para gerar a URL

    // SOLID
    @Autowired
    private JsonConversionService jsonConversionService; // Injetando o novo serviço de conversão

    // SOLID
    @Autowired
    private LogService logService; // Novo serviço de log

    // SOLID
    @Autowired
    private HttpClientService httpClientService;

    // public EnderecoDTO buscarCep(String cep) {
    // System.out.println(" --- Service ---");
    // logger.info("Buscando informações para o CEP: {}", cep);

    // // URL da API externa ViaCEP
    // String url = "https://viacep.com.br/ws/" + cep + "/json/";

    // RestTemplate restTemplate = new RestTemplate();

    // try {
    // EnderecoDTO endereco = restTemplate.getForObject(url, EnderecoDTO.class);

    // if (endereco != null && endereco.getCep() != null) {

    // // Converter o objeto EnderecoDTO para JSON
    // String enderecoJson = objectMapper.writeValueAsString(endereco);

    // // Salvar log no banco de dados
    // LogConsulta log = new LogConsulta(null, url, enderecoJson,
    // LocalDateTime.now());
    // log.setCep(cep);
    // logConsultaRepository.save(log);

    // return endereco;
    // } else {
    // throw new RuntimeException("CEP não encontrado ou resposta inválida.");
    // }
    // } catch (Exception e) {
    // logger.error("Erro ao buscar CEP: {}", e.getMessage(), e);
    // throw new RuntimeException("Erro ao buscar CEP: " + e.getMessage());
    // }

    // }

    // SOLID

    public EnderecoDTO buscarCep(String cep) throws Exception {
        logger.info(" 2º Service > Buscando informacoes para o CEP: {}", cep);
        try {
            // URL é gerada pelo UrlCepService
            String url = urlCepService.gerarUrlPorCep(cep);

            // RestTemplate restTemplate = new RestTemplate();

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
