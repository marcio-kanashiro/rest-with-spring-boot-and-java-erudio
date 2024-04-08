package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.Utils;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();
    
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
        ) throws Exception {
        
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.sum(Utils.convertToDouble(numberOne), Utils.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
        ) throws Exception {
        
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.sub(Utils.convertToDouble(numberOne), Utils.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
        ) throws Exception {
        
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.mult(Utils.convertToDouble(numberOne), Utils.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
        ) throws Exception {
        
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (numberTwo.equals("0")) {
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        }

        return math.div(Utils.convertToDouble(numberOne), Utils.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mean(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
        ) throws Exception {
        
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.mean(Utils.convertToDouble(numberOne), Utils.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value="number") String number
        ) throws Exception {
        
        if (!Utils.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.squareRoot(Utils.convertToDouble(number));
    }

}
