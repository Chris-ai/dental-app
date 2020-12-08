package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Order;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class OrderDtoMapper {

    public static List<OrderDto> mapToOrderDtos(List<Order> orders){
        return orders.stream()
                .map(OrderDtoMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    public static OrderDto mapToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .amount(order.getAmount())
                .orderDate(order.getOrderDate())
                .price(order.getPrice())
                .medicineName(order.getMedicine().getName())
                .build();
    }
}
