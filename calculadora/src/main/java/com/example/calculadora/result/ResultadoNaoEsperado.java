package com.example.calculadora.result;

public class ResultadoNaoEsperado implements Resultado{
    private String resultado;

    public ResultadoNaoEsperado(String resultado) {
        this.resultado = resultado;
    }

    public ResultadoNaoEsperado() {
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
