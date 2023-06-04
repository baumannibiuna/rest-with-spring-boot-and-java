package com.baumannibiuna.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baumannibiuna.rest.exceptions.UnsupportedMathOperationException;
import com.baumannibiuna.rest.operations.NumberTest;
import com.baumannibiuna.rest.operations.SimpleMath;

//Classe responsavel por disponibilizar o end point para a aplicaçao
@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberTest.isNumeric(numberOne) || !NumberTest.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(NumberTest.convertToDouble(numberOne) , NumberTest.convertToDouble(numberTwo));
    }    
    
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberTest.isNumeric(numberOne) || !NumberTest.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
        return math.sub(NumberTest.convertToDouble(numberOne) , NumberTest.convertToDouble(numberTwo));
	}    
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberTest.isNumeric(numberOne) || !NumberTest.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
        return math.mult(NumberTest.convertToDouble(numberOne) , NumberTest.convertToDouble(numberTwo));
	}    
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberTest.isNumeric(numberOne) || !NumberTest.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
        return math.div(NumberTest.convertToDouble(numberOne) , NumberTest.convertToDouble(numberTwo));
	}    
	@RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberTest.isNumeric(numberOne) || !NumberTest.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
        return math.med(NumberTest.convertToDouble(numberOne) , NumberTest.convertToDouble(numberTwo));
	}    
	@RequestMapping(value="/sqr/{number}", method=RequestMethod.GET)
	public Double sqr(@PathVariable("number") String number)
			throws Exception {
		if (!NumberTest.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.sqr(NumberTest.convertToDouble(number));
	}    

}
