package br.com.yuugure.calculadora;

import br.com.yuugure.exceptions.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
                method = RequestMethod.GET)
    public Double sum (
                @PathVariable (value = "numberOne") String numberOne,
                @PathVariable (value = "numberTwo") String numberTwo) 
        throws UnsupportedMathOperationException 
    {
        if (!isDNumeric(numberOne) || !isDNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please insert a number here.");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    
    public boolean isDNumeric (String strNumber) {
        if (strNumber == null)  return false;

        String number = strNumber.replaceAll(",", ".");
        
        return number.matches("[+-]?[0-9]+\\.?[0-9]*");
    }

    public Double convertToDouble (String strNumber) throws UnsupportedMathOperationException {
        strNumber = strNumber.replaceAll(",", ".");
        if (isDNumeric(strNumber)) return Double.parseDouble(strNumber);
        throw new UnsupportedMathOperationException("Número Inválido!");
    }
}