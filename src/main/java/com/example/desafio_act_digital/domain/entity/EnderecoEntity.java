package com.example.desafio_act_digital.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ENDERECO")
public class EnderecoEntity extends AbstractEntity {
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "UNIDADE")
	private String unidade;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "LOCALIDADE")
	private String localidade;
	
	@Column(name = "UF")
	private String uf;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "REGIAO")
	private String regiao;
	
	@Column(name = "IBGE")
	private String ibge;
	
	@Column(name = "GIA")
	private String gia;
	
	@Column(name = "DDD")
	private String ddd;
	
	@Column(name = "SIAFI")
	private String siafi;
	
	@Column(name = "PAIS")
	private String pais;
	
	@OneToOne(mappedBy = "endereco")
    private LogEnderecoEntity log;
	
}
