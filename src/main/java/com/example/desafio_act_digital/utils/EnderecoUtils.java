package com.example.desafio_act_digital.utils;

import org.springframework.stereotype.Component;

import com.example.desafio_act_digital.domain.dto.EnderecoDTO;
import com.example.desafio_act_digital.domain.entity.EnderecoEntity;

@Component
public class EnderecoUtils {

	public EnderecoEntity dtoToEntity(EnderecoDTO enderecoDto) {
		EnderecoEntity endereco = new EnderecoEntity();
		
		endereco.setCep(enderecoDto.getCep());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setUnidade(enderecoDto.getUnidade());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setLocalidade(enderecoDto.getLocalidade());
		endereco.setUf(enderecoDto.getUf());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setRegiao(enderecoDto.getRegiao());
		endereco.setIbge(enderecoDto.getIbge().toString());
		endereco.setGia(enderecoDto.getGia().toString());
		endereco.setDdd(enderecoDto.getDdd().toString());
		endereco.setSiafi(enderecoDto.getSiafi().toString());
		endereco.setPais(enderecoDto.getPais());
		
		return endereco;
	}
	
	public EnderecoDTO entityToDto(EnderecoEntity enderecoEntity) {
		EnderecoDTO endereco = new EnderecoDTO();
		
		endereco.setId(enderecoEntity.getId());
		endereco.setCep(enderecoEntity.getCep());
		endereco.setLogradouro(enderecoEntity.getLogradouro());
		endereco.setComplemento(enderecoEntity.getComplemento());
		endereco.setUnidade(enderecoEntity.getUnidade());
		endereco.setBairro(enderecoEntity.getBairro());
		endereco.setLocalidade(enderecoEntity.getLocalidade());
		endereco.setUf(enderecoEntity.getUf());
		endereco.setEstado(enderecoEntity.getEstado());
		endereco.setRegiao(enderecoEntity.getRegiao());
		endereco.setIbge(Integer.valueOf(enderecoEntity.getIbge()));
		endereco.setGia(Integer.valueOf(enderecoEntity.getGia()));
		endereco.setDdd(Short.valueOf(enderecoEntity.getDdd()));
		endereco.setSiafi(Integer.valueOf(enderecoEntity.getSiafi()));
		endereco.setPais(enderecoEntity.getPais());
		
		return endereco;
	}
	
}
