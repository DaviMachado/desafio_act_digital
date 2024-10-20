package com.example.desafio_act_digital.service;

import com.example.desafio_act_digital.domain.dto.EnderecoDTO;

public interface IEnderecoService {

	EnderecoDTO buscarCep(String cep);
	
}
