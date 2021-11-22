package com.example.calculadora.handler;

//import com.example;
import com.example.calculadora.operacao.*;
import com.example.calculadora.result.ResultadoEsperado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

@Component
public class ImplementacaoHandlerDeMensagens implements HandlerDeMensagens {
    @Override
    public ResultadoEsperado processarMensagem(String tipoOperacao, BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado;
        Operacao ope = null;
        ope = criarObjeto(tipoOperacao);
        resultado = ope.calcular(valor1, valor2);
        return new ResultadoEsperado(resultado);
    }

    private static Operacao criarObjeto(String nomeDaClasse)  {
        Operacao operacao;
        switch (nomeDaClasse) {
            case "sum":
                operacao = new Adicao();
                break;
            case "sub":
                operacao = new Subtracao();
                break;
            case "mul":
                operacao = new Multiplicacao();
            case "div":
                operacao = new Divisao();
                break;
            default:
                operacao = null;
                break;

        }

        return (Operacao) operacao;
    }

    private static final Logger logger = LoggerFactory.getLogger(ImplementacaoHandlerDeMensagens.class);
}
