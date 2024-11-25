package com.diegoduarte.order.integration;

import com.diegoduarte.order.model.Order;
import com.diegoduarte.order.model.OrderStatus;
import com.diegoduarte.order.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderEvent {

    private Long id;

    private Long customerId;

    private OrderStatus status;

    private List<ProductEvent> products;
}
