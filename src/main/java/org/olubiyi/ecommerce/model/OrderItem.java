package org.olubiyi.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_Id", nullable = false)
    private Order order;

}