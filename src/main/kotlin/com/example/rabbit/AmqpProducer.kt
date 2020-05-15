package com.example.rabbit

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class AmqpProducer {

    @Autowired
    private lateinit var rabbitTemplate: AmqpTemplate

    @Value("\${rabbitmq.exchange}")
    private lateinit var exchange: String

    @Value("\${rabbitmq.routingkey}")
    private lateinit var routingkey: String

    fun send(companyName: String) {
        rabbitTemplate.convertAndSend(exchange, routingkey, companyName)
    }
}