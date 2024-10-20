package com.example.desafio_act_digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafio_act_digital.domain.entity.LogEnderecoEntity;

@Repository
public interface LogEnderecoRepository extends JpaRepository<LogEnderecoEntity, Long> {

}
