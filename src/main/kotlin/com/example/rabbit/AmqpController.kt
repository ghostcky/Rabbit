package com.example.rabbit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AmqpController {

    @Autowired
    lateinit var sender: AmqpProducer

    @GetMapping("send")
    // По хорошему использовать POST, но чтобы не устанавливать Postman будем использовать GET
    // и отправлять через браузерное окно
    fun send(@RequestParam companyName: String) {
        sender.send(companyName)
    }
}