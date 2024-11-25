package com.diegoduarte.order.controller.response;

import com.diegoduarte.order.model.Order;
import com.diegoduarte.order.model.OrderStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderResponse {

    private Long customerId;
    private BigDecimal total;
    private OrderStatus status;
    private List<ProductResponse> products;

    public OrderResponse(Order order) {
        var products = order.getProducts();

        this.customerId = order.getCustomerId();
        this.status = order.getStatus();
        this.products = products.stream().map(ProductResponse::new).toList();
        this.total = products.stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
