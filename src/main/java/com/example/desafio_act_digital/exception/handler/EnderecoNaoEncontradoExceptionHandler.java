package com.example.desafio_act_digital.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.desafio_act_digital.domain.dto.ErrorDTO;
import com.example.desafio_act_digital.exception.EnderecoNaoEncontradoException;

@ControllerAdvice
public class EnderecoNaoEncontradoExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(EnderecoNaoEncontradoException.class)
	public ErrorDTO handler(EnderecoNaoEncontradoException ex) {
		return new ErrorDTO(
				ex.getMessage(),
				ex.getStatus().toString()
			);
	}
}
