package com.example.busca_cep.controller;

import com.example.busca_cep.dto.EnderecoDTO;
import com.example.busca_cep.service.ConsultaCepService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@WebMvcTest(ConsultaCepController.class)
public class ConsultaCepControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaCepService consultaCepService;

    @Test
    void deveRetornarEnderecoParaCepValido() throws Exception {
        String cep = "12345678";
        EnderecoDTO enderecoMock = new EnderecoDTO();
        enderecoMock.setCep(cep);

        Mockito.when(consultaCepService.buscarCep(cep)).thenReturn(enderecoMock);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cep/" + cep)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cep").value(cep));
    }
    
}
