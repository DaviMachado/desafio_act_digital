package com.example.desafio_act_digital.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Endereco Controller")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class EnderecoControllerIT extends BaseControllerIT {
	
	private static StringBuilder path = new StringBuilder(URL);
	
	@BeforeEach
	void inicializar() {
		path.append(URL_ENDERECO);
		prepareMockServer(METHOD_GET, ("/" + REGEX_8_DIGITOS + PATH_JSON), STATUS_200, bodyMockSucess());
		prepareMockServer(METHOD_GET, ("/" + REGEX_MAIS_DE_8_DIGITOS + PATH_JSON), STATUS_400, bodyMockFailed());
	}

	@AfterEach
	void finalizar() {
		path = new StringBuilder(URL);
	}
	
    
    @Nested
	@DisplayName("GET /endereco")
	class Get {
    	
    	@Nested
		@DisplayName("Deve retornar http status 200")
		class Sucess {
    		
    		@Test
    	    @DisplayName("Deve retornar um CEP")
    	    public void testBuscarCep() {
    			HttpEntity<Void> corpoRequisicao = new HttpEntity<>(null);
    			ResponseEntity<String> corpoResposta = restTemplate.exchange((URL_ENDERECO + "/01153000"), HttpMethod.GET, corpoRequisicao, String.class);

    			assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
    		    Assert.assertNotNull(corpoResposta.getBody());
    	    }
    	}
    	
    	@Nested
		@DisplayName("Deve retornar http status 400")
		class Failed {
    		
    		@Test
    	    @DisplayName("Não deve retornar um CEP")
    	    public void testBuscarCepError() {
    			HttpEntity<Void> corpoRequisicao = new HttpEntity<>(null);
    			ResponseEntity<String> corpoResposta = restTemplate.exchange((URL_ENDERECO + "/000000000"), HttpMethod.GET, corpoRequisicao, String.class);

    			assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
    	    }
    	}
    }
    
}
