package com.example.rest.controller;

import com.example.calculadora.result.Resultado;
import com.example.rest.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@RestController
@RequestMapping("/")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }




    @CrossOrigin(origins = "*")
    @GetMapping("{operationType}")

    public Resultado calculate(
            HttpServletResponse response,
            @PathVariable("operationType") String operationType,
            @RequestParam(value = "a") BigDecimal a,
            @RequestParam(value = "b") BigDecimal b)
    {

        return calculatorService.calculate(response, operationType, a, b);
    }


}
