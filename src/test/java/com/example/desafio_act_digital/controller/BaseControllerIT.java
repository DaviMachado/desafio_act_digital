package com.example.desafio_act_digital.controller;

import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.springtest.MockServerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.example.desafio_act_digital.DesafioActDigitalApplication;

@MockServerTest
@SuppressWarnings("resource")
@SpringBootTest(classes = { DesafioActDigitalApplication.class })
@ActiveProfiles("test")
public abstract class BaseControllerIT {
	
	protected static final String METHOD_GET = "GET";
	
	protected static final String URL = "http://localhost:3030/act_digital";
	
	protected static final String URL_ENDERECO = "/endereco";
	
	protected static final String PATH_JSON = "/json";

	protected static final String REGEX_8_DIGITOS = "\\d{8}";
	
	protected static final String REGEX_MAIS_DE_8_DIGITOS = "\\d+";
	
	protected static final int STATUS_200 = 200;
	
	protected static final int STATUS_400 = 400;

	@Autowired
	protected TestRestTemplate restTemplate;
	
	protected MockServerClient mockServerClient;
	
	protected void prepareMockServer(final String method, final String path, final int status, final String body) {
		mockServerClient.when(HttpRequest.request() //
				.withMethod(method) //
				.withPath(path) //
				).respond( //
						HttpResponse.response() //
				            .withStatusCode(status) //
				            .withHeader("Content-Type", "application/json") //
				            .withBody(body) //
				    );
	}
	
	protected String bodyMockSucess() {
		return "{" +
	    "  \"cep\": \"01001-000\"," +
	    "  \"logradouro\": \"Teste\"," +
	    "  \"complemento\": \"Teste\"," +
	    "  \"unidade\": \"\"," +
	    "  \"bairro\": \"Teste\"," +
	    "  \"localidade\": \"Teste\"," +
	    "  \"uf\": \"Teste\"," +
	    "  \"estado\": \"Teste\"," +
	    "  \"regiao\": \"Teste\"," +
	    "  \"ibge\": \"0000000\"," +
	    "  \"gia\": \"0000\"," +
	    "  \"ddd\": \"00\"," +
	    "  \"siafi\": \"0000\"" +
	    "}";
	}
	
	protected String bodyMockFailed() {
		return "{" +
	    "\"erro\": \"CEP inválido\"" +
	    "}";
	}

}
