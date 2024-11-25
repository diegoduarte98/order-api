package com.diegoduarte.order.service;

import com.diegoduarte.order.controller.response.OrderResponse;
import com.diegoduarte.order.integration.OrderEvent;
import com.diegoduarte.order.integration.OrderHelper;
import com.diegoduarte.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    private final OrderHelper helper;

    public Page<OrderResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(OrderResponse::new);
    }

    @Transactional
    public void createFromEvent(OrderEvent event) {
        var order = repository.findByOrderId(event.getId())
                .map(existingOrder -> helper.updateExistingOrder(existingOrder, event))
                .orElseGet(() -> helper.createNewOrder(event));
        repository.save(order);
    }
}
