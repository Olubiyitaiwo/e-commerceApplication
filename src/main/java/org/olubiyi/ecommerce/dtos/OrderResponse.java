package org.olubiyi.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.olubiyi.ecommerce.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private List<OrderItemDTO> items;
    private LocalDateTime createdAt;
}
