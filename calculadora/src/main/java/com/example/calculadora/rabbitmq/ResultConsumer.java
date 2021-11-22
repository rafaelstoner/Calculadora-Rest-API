package com.example.calculadora.rabbitmq;

import com.example.calculadora.operacao.Operacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ResultConsumer {

    private static final Logger log = LoggerFactory.getLogger(ResultConsumer.class);

    @RabbitListener(queues = RabbitConfig.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(final Operacao operacao) {
        log.info("Received operation is: {}", operacao.toString());

    }


}
