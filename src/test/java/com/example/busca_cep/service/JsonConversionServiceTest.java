// package com.example.busca_cep.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import com.example.busca_cep.dto.EnderecoDTO;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.slf4j.Logger;

// @ExtendWith(MockitoExtension.class)
// public class JsonConversionServiceTest {

//     @Mock
//     private Logger logger;

//     @Mock
//     private ObjectMapper objectMapper;

//     @InjectMocks
//     private JsonConversionService jsonConversionService;

//     @Test
//     public void testConverterParaJson() throws Exception {
//         // Arrange
//         EnderecoDTO endereco = new EnderecoDTO("01001-000", "Praça da Sé", "São Paulo", "SP", null, null, null);
//         String jsonEsperado = "{\"cep\":\"01001-000\",\"logradouro\":\"Praça da Sé\",\"cidade\":\"São Paulo\",\"uf\":\"SP\"}";

//         // Act
//         when(objectMapper.writeValueAsString(any(EnderecoDTO.class))).thenReturn(jsonEsperado);
//         String jsonGerado = jsonConversionService.converterParaJson(endereco);

//         // Assert
//         assertEquals(jsonEsperado, jsonGerado);
//         verify(logger).info(" 5º converterParaJson > " + jsonEsperado);
//     }

//     @Test
//     public void testConverterParaJsonComEnderecoNull() {
//         // Arrange
//         EnderecoDTO endereco = null;

//         // Act e Assert
//         assertThrows(NullPointerException.class, () -> jsonConversionService.converterParaJson(endereco));
//     }

//     @Test
//     public void testConverterParaJsonComException() throws Exception {
//         // Arrange
//         EnderecoDTO endereco = new EnderecoDTO("01001-000", "Praça da Sé", "São Paulo", "SP", null, null, null);
//         when(objectMapper.writeValueAsString(any(EnderecoDTO.class))).thenThrow(new Exception("Erro ao converter para JSON"));

//         // Act e Assert
//         assertThrows(Exception.class, () -> jsonConversionService.converterParaJson(endereco));
//     }
    
// }
