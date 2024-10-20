package com.example.desafio_act_digital.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO {

	private Long id;
	private String cep;
	private String logradouro;
	private String complemento;
	private String unidade;
	private String bairro;
	private String localidade;
	private String uf;
	private String estado;
	private String regiao;
	private Integer ibge;
	private Integer gia;
	private Short ddd;
	private Integer siafi;
	private String pais;
	
}
