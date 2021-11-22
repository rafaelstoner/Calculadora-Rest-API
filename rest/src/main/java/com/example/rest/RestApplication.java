package com.example.rest;

import com.example.calculadora.handler.HandlerDeMensagens;
import com.example.calculadora.handler.ImplementacaoHandlerDeMensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }



}
