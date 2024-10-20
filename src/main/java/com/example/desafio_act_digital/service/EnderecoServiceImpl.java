package com.example.desafio_act_digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desafio_act_digital.domain.dto.EnderecoDTO;
import com.example.desafio_act_digital.domain.entity.EnderecoEntity;
import com.example.desafio_act_digital.exception.EnderecoNaoEncontradoException;
import com.example.desafio_act_digital.repository.EnderecoRepository;
import com.example.desafio_act_digital.utils.EnderecoUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnderecoServiceImpl implements IEnderecoService {

	@Autowired
	private EnderecoUtils enderecoUtils;
	@Autowired
	private ViaCepService viaCepService;
	@Autowired
	private LogEnderecoService logEnderecoService;
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	@Override
	public EnderecoDTO buscarCep(String cep) {
		try {
			EnderecoDTO endereco = viaCepService.buscarCep(cep);
			EnderecoEntity enderecoSalvo = enderecoRepository.save(enderecoUtils.dtoToEntity(endereco));
			logEnderecoService.salvarLog(enderecoSalvo);
			
			return enderecoUtils.entityToDto(enderecoSalvo);
		} catch (Exception e) {
			log.error("Erro ao salvar buscar o CEP !!");
			throw new EnderecoNaoEncontradoException("Erro ao salvar buscar o CEP !!", HttpStatus.BAD_REQUEST);
		}
	}

}
