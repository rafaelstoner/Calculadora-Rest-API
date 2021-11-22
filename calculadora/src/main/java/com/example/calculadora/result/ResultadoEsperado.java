package com.example.calculadora.result;

import java.math.BigDecimal;

public class ResultadoEsperado implements Resultado{

    private BigDecimal resultado;

    public ResultadoEsperado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    public ResultadoEsperado() {
    }

    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ResultadoEsperado{" +
                "resultado=" + resultado +
                '}';
    }
}
