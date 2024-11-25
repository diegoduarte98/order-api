package com.diegoduarte.order.controller;

import com.diegoduarte.order.controller.documentation.OrderDocumentation;
import com.diegoduarte.order.controller.response.OrderResponse;
import com.diegoduarte.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController implements OrderDocumentation {

    private final OrderService service;

    @GetMapping
    public Page<OrderResponse> getAll(@ParameterObject Pageable pageable) {
        return service.getAll(pageable);
    }
}
