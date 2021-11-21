package com.example.calculadora.operacao;

import java.math.BigDecimal;

public class Adicao implements Operacao{
    @Override
    public BigDecimal calcular(BigDecimal valor1, BigDecimal valor2) {
        return valor1.add(valor2);
    }
}
