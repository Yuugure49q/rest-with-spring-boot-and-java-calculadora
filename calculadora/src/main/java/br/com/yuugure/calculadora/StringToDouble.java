package br.com.yuugure.calculadora;

import br.com.yuugure.calculadora.exceptions.UnsupportedMathOperationException;

public class StringToDouble {

    public static boolean isDNumeric (String strNumber) {
        if (strNumber == null)  return false;

        String number = strNumber.replaceAll(",", ".");
        
        return number.matches("[+-]?[0-9]+\\.?[0-9]*");
    }

    public static Double convertToDouble (String strNumber) throws UnsupportedMathOperationException {
        strNumber = strNumber.replaceAll(",", ".");
        if (isDNumeric(strNumber)) return Double.parseDouble(strNumber);
        throw new UnsupportedMathOperationException("Número Inválido!");
    }
}