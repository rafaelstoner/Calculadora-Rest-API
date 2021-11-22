package com.example.calculadora.handler;

import com.example.calculadora.result.ResultadoEsperado;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public interface HandlerDeMensagens {


    ResultadoEsperado processarMensagem(String tipoOperacao, BigDecimal valor1, BigDecimal valor2) ;
}
