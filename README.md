# BuscadorCep
 
Faça um desenho de solução para explicação da sua aplicação;

Sua aplicação deverá prover a capacidade de realizar as operações de busca de cep em uma api externa (de preferência para fazer a api mocada com Wiremock, Mockoon ou similar);

Os logs das consultas precisam ser gravados em base de dados, com o horário da consulta e os dados que retornaram da api.

Sua aplicação deverá utilizar os conceitos básicos de SOLID;

---
 # Tecnologias Utilizadas
Spring Boot: Framework para desenvolvimento da aplicação.

RestTemplate: Cliente HTTP para realizar as requisições para os providers.

JPA (Spring Data): Para gravação de logs de consulta no banco de dados.

Docker : Postgres Banco de dados para armazenamento dos logs.


---
# Como utilizar

1 -  Inicializando a Aplicação Para rodar a aplicação, basta executar o comando:
      mvn spring-boot:run

2 -  Consultando um CEP Para consultar um CEP, faça uma requisição GET para o seguinte endpoint:
      GET /api/cep/{cep}


Retorno esperado:
 
    {
            "cep": "string",      
            "logradouro": "string",   
            "numero": "string",  
            "complemento": "string",    
            "bairro": "string",    
            "localidade": "string",  
            "uf": "string"  
    }


# Fluxo da Consulta de CEP

![image](https://github.com/user-attachments/assets/cac91661-3192-4f4c-87b4-8428d7a654cd)

# Visualização do Banco
![image](https://github.com/user-attachments/assets/2ffea8a1-1680-42d0-a7c8-3f09e86ad48a)





