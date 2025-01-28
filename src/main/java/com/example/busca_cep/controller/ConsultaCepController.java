package com.example.busca_cep.controller;

import com.example.busca_cep.dto.EnderecoDTO;
import com.example.busca_cep.service.ConsultaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> buscarCep(
            @PathVariable("cep") @NotBlank(message = "O CEP deve ser informado e não pode estar em branco") String cep) {
        logger.info("Iniciando --- Controller > busca de CEP: {}", cep);

        // Validação de formato do CEP (somente 8 dígitos numéricos)
        if (!cep.matches("\\d{8}")) {
            logger.warn("Formato inválido para o CEP: {}", cep);
            return ResponseEntity.badRequest()
                    .body("Formato inválido: o CEP deve conter exatamente 8 dígitos numéricos.");
        }

        try {
            EnderecoDTO endereco = consultaCepService.buscarCep(cep);
            return ResponseEntity.ok(endereco);
        } catch (Exception e) {
            logger.error("Erro ao processar o CEP: {}", cep, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao buscar o CEP. Tente novamente mais tarde.");
        }

    }
}