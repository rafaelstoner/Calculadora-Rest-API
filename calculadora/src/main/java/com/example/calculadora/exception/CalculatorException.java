package com.example.calculadora.exception;

public class CalculatorException extends RuntimeException {
    public CalculatorException() {
        super();
    }

    public CalculatorException(String s) {
        super(s);
    }

    public CalculatorException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CalculatorException(Throwable throwable) {
        super(throwable);
    }

    private static final long serialVersionUID = 1L;

}
