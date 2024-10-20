package com.example.desafio_act_digital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio_act_digital.domain.dto.EnderecoDTO;
import com.example.desafio_act_digital.service.EnderecoServiceImpl;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoServiceImpl enderecoServiceImpl;
	
	@GetMapping("/{cep}")
	@ResponseStatus(HttpStatus.OK)
	public EnderecoDTO buscarCep(@PathVariable String cep) {
		return enderecoServiceImpl.buscarCep(cep);
	}

}
