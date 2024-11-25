package com.diegoduarte.order.controller.response;

import com.diegoduarte.order.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductResponse {

    private String name;
    private Integer quantity;
    private BigDecimal price;

    public ProductResponse(Product product) {
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
    }
}
