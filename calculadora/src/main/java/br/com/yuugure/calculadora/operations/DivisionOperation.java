package br.com.yuugure.calculadora.operations;

import br.com.yuugure.calculadora.exceptions.UnsupportedMathOperationException;

public class DivisionOperation {
    private DivisionOperation () {}
    public static Double divOP (Double n1, Double n2) {
        if (n2.equals(0D)) throw new UnsupportedMathOperationException("It's impossible divide by 0");
        return n1 / n2;
    }
}
