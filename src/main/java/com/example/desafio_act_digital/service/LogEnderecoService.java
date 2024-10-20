package com.example.desafio_act_digital.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_act_digital.domain.entity.EnderecoEntity;
import com.example.desafio_act_digital.domain.entity.LogEnderecoEntity;
import com.example.desafio_act_digital.repository.LogEnderecoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LogEnderecoService {

	@Autowired
	private LogEnderecoRepository logEnderecoRepository;
	
	
	public void salvarLog(EnderecoEntity endereco) {

		LogEnderecoEntity log = new LogEnderecoEntity();
		log.setAcao("Inserção"); // Ex: Inserção, Atualização, Exclusão
		log.setDataHora(LocalDateTime.now());
		log.setObservacao("");
		log.setEndereco(endereco);
		
		logEnderecoRepository.save(log);
	}

}
