package com.diegoduarte.order.integration;

import com.diegoduarte.order.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductEvent {

    private Long id;

    private String name;

    private Integer quantity;

    private BigDecimal price;
}
