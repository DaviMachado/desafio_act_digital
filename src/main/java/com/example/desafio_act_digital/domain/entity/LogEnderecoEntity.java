package com.example.desafio_act_digital.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "LOG_ENDERECO")
public class LogEnderecoEntity extends AbstractEntity {
	
	@Column(name = "ACAO")
	private String acao;
	
	@Column(name = "DATA_HORA")
	private LocalDateTime dataHora;
	
	@Column(name = "OBSERVACAO")
	private String observacao;
	
	@OneToOne
    @JoinColumn(name = "ENDERECO_ID")
    private EnderecoEntity endereco;
	
}
