package com.example.rabbit

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service
import java.lang.RuntimeException


@Service
class AmqpConsumer {

    @RabbitListener(queues = ["\${rabbitmq.queue}"])
    fun listen(companyName: String?) {
        println(companyName)
        Thread.sleep(10000)
    }

}