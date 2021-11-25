package com.example.rest.service;

import com.example.calculadora.handler.ImplementacaoHandlerDeMensagens;
import com.example.calculadora.operacao.Operacao;
import com.example.calculadora.result.Resultado;
import com.example.calculadora.result.ResultadoNaoEsperado;
import com.example.rest.rabbitmq.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class CalculatorService {
    private final RabbitTemplate rabbitTemplate;

    private static final Logger log = LoggerFactory.getLogger(Operacao.class);

    @Autowired
    public CalculatorService(final RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    public Resultado calculate(HttpServletResponse response, String operationType, BigDecimal firstValue, BigDecimal secondValue){

        Resultado result;

        if( operationType.equalsIgnoreCase("div") && secondValue.equals(BigDecimal.ZERO)){
            result =  new ResultadoNaoEsperado("Não é possível dividir por zero");
        }

        else{
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, (new ImplementacaoHandlerDeMensagens()).processarMensagem(operationType,firstValue,secondValue));
            log.info("Practical Tip sent");
            result = (new ImplementacaoHandlerDeMensagens()).processarMensagem(operationType,firstValue,secondValue);
        }
        response.addHeader("Identificador único", new UUID(System.currentTimeMillis(), System.currentTimeMillis()).toString());
        return result;


    }



}
