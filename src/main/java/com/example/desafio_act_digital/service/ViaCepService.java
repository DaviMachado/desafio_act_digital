package com.example.desafio_act_digital.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.desafio_act_digital.domain.dto.EnderecoDTO;
import com.example.desafio_act_digital.exception.EnderecoNaoEncontradoException;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ViaCepService {
	
	@Autowired(required=true)
	RestTemplate restTemplate;

	public EnderecoDTO buscarCep(String cep) {
		Gson gson = new Gson();
		
		try {						
			HttpEntity<Void> request = new HttpEntity<>(null);
			ResponseEntity<String> response = restTemplate
					.exchange(
								new URI("https://viacep.com.br/ws/" + cep + "/json/"), 
								HttpMethod.GET,
								request, 
								String.class
							);

			int status = response.getStatusCode().value();
			
			if (status == HttpStatus.OK.value()) {
				log.info("CEP encontrado !!");
				
				EnderecoDTO endereco = gson.fromJson(response.getBody(), EnderecoDTO.class);
	            return endereco;
			}
			else {
				log.error("Endereço não encontrado !!");
				throw new EnderecoNaoEncontradoException("Endereço não encontrado !!", HttpStatus.BAD_REQUEST);
			} 
		} catch (URISyntaxException e) {
            System.out.println("Erro na URI: " + e.getMessage());
            throw new EnderecoNaoEncontradoException("Erro na URI: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
			log.error("Erro ao buscar o CEP atrevés da API do ViaCep !!");
			throw new EnderecoNaoEncontradoException("Erro ao buscar o CEP atrevés da API do ViaCep !!", HttpStatus.BAD_REQUEST);
		}
	}
	
}
