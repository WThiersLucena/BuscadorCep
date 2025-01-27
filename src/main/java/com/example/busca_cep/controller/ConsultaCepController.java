package com.example.busca_cep.controller;

import com.example.busca_cep.dto.EnderecoDTO;
import com.example.busca_cep.service.ConsultaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/cep")
public class ConsultaCepController {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCepController.class);

    @Autowired
    private ConsultaCepService consultaCepService;

    @GetMapping("/{cep}")
    public EnderecoDTO buscarCep(
            @PathVariable("cep") @NotBlank(message = "O CEP deve ser informado e não pode estar em branco") String cep)
            throws Exception {
        logger.info("Iniciando --- Controller > busca de CEP: {}", cep);
        return consultaCepService.buscarCep(cep);
    }
}
