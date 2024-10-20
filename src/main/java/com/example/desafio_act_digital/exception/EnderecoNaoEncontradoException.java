package com.example.desafio_act_digital.exception;

import org.springframework.http.HttpStatus;

public class EnderecoNaoEncontradoException extends RuntimeException {
    private final HttpStatus status;

    public EnderecoNaoEncontradoException(String mensagem, HttpStatus status) {
        super(mensagem);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
