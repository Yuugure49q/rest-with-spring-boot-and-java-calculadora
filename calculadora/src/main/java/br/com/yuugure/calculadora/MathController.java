package br.com.yuugure.calculadora;

import org.springframework.web.bind.annotation.RestController;

import br.com.yuugure.calculadora.exceptions.UnsupportedMathOperationException;

import static br.com.yuugure.calculadora.operations.SumOperation.sumOP;
import static br.com.yuugure.calculadora.operations.SubtractOperation.subOP;
import static br.com.yuugure.calculadora.operations.MultiplicationOperation.multOP;
import static br.com.yuugure.calculadora.operations.DivisionOperation.divOP;
import static br.com.yuugure.calculadora.operations.AverageOperation.averageOP;
import static br.com.yuugure.calculadora.operations.SquareRootOperation.sqrtOP;

import static br.com.yuugure.calculadora.StringToDouble.convertToDouble;

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
        return sumOP(convertToDouble(numberOne), convertToDouble(numberTwo));
    }
    
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
                method = RequestMethod.GET)
    public Double sub (
                @PathVariable (value = "numberOne") String numberOne,
                @PathVariable (value = "numberTwo") String numberTwo) 
        throws UnsupportedMathOperationException 
    {
        return subOP(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}",
                method = RequestMethod.GET)
    public Double mult (
                @PathVariable (value = "numberOne") String numberOne,
                @PathVariable (value = "numberTwo") String numberTwo) 
        throws UnsupportedMathOperationException 
    {
        return multOP(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",
                method = RequestMethod.GET)
    public Double div (
                @PathVariable (value = "numberOne") String numberOne,
                @PathVariable (value = "numberTwo") String numberTwo) 
        throws UnsupportedMathOperationException 
    {
        return divOP(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}",
                method = RequestMethod.GET)
    public Double average (
                @PathVariable (value = "numberOne") String numberOne,
                @PathVariable (value = "numberTwo") String numberTwo) 
        throws UnsupportedMathOperationException 
    {
        return averageOP(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sqrt/{number}",
                method = RequestMethod.GET)
    public Double sqrt (
                @PathVariable (value = "number") String number) 
        throws UnsupportedMathOperationException 
    {
        return sqrtOP(convertToDouble(number));
    }
}