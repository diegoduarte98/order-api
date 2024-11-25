package com.diegoduarte.order.integration;

import com.diegoduarte.order.model.Order;
import com.diegoduarte.order.model.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderHelper {

    public Order updateExistingOrder(Order existingOrder, OrderEvent event) {
        existingOrder.setStatus(event.getStatus());
        existingOrder.getProducts().clear();
        event.getProducts().forEach(productEvent ->
                existingOrder.addProduct(mapToProduct(productEvent))
        );
        return existingOrder;
    }

    public Order createNewOrder(OrderEvent event) {
        var newOrder = Order.builder()
                .orderId(event.getId())
                .customerId(event.getCustomerId())
                .status(event.getStatus())
                .build();

        event.getProducts().forEach(productEvent ->
                newOrder.addProduct(mapToProduct(productEvent))
        );
        return newOrder;
    }

    private Product mapToProduct(ProductEvent productEvent) {
        return Product.builder()
                .productId(productEvent.getId())
                .name(productEvent.getName())
                .quantity(productEvent.getQuantity())
                .price(productEvent.getPrice())
                .build();
    }
}
