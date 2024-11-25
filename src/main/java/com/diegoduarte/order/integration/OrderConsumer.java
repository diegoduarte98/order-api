package com.diegoduarte.order.integration;

import com.diegoduarte.order.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderService service;

    @Transactional
    @RabbitListener(queues = "order.items")
    public void consumer(@Payload OrderEvent event) {
        service.createFromEvent(event);
    }
}
