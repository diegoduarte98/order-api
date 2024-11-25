package com.diegoduarte.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;

    private String name;

    private Integer quantity;

    private BigDecimal price;

    @Setter
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
