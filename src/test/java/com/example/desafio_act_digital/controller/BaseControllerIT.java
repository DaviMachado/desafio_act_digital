package com.example.desafio_act_digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.example.desafio_act_digital.DesafioActDigitalApplication;

@SuppressWarnings("resource")
@SpringBootTest(classes = { DesafioActDigitalApplication.class })
@ActiveProfiles("test")
public abstract class BaseControllerIT {
	
	protected static final String URL = "http://localhost:3030/act_digital";
	
	protected static final String URL_ENDERECO = "/endereco";

	@Autowired
	protected TestRestTemplate restTemplate;

}
