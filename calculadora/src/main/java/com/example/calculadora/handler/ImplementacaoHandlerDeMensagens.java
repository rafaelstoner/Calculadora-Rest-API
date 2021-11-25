package com.example.calculadora.handler;


import com.example.calculadora.operacao.*;
import com.example.calculadora.result.ResultadoEsperado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ImplementacaoHandlerDeMensagens implements HandlerDeMensagens {
    @Override
    public ResultadoEsperado processarMensagem(String tipoOperacao, BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado;
        Operacao ope = criarObjeto(tipoOperacao);
        resultado = ope.calcular(valor1, valor2);
        return new ResultadoEsperado(resultado);
    }

    private static Operacao criarObjeto(String nomeDaClasse)  {

        return switch (nomeDaClasse) {
            case "sum" -> new Adicao();
            case "sub" -> new Subtracao();
            case "mul" -> new Multiplicacao();
            case "div" -> new Divisao();
            default -> null;
        };
    }

    private static final Logger logger = LoggerFactory.getLogger(ImplementacaoHandlerDeMensagens.class);
}
