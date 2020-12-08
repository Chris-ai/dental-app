package com.example.dentalapp.controller;

import com.example.dentalapp.model.Order;
import com.example.dentalapp.model.dto.OrderDto;
import com.example.dentalapp.model.dto.OrderDtoMapper;
import com.example.dentalapp.service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<OrderDto> getOrders(){
        return OrderDtoMapper.mapToOrderDtos(orderService.getOrders());
    }

    @GetMapping("/orders/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public OrderDto getOrder(@PathVariable long id){
        return OrderDtoMapper.mapToOrderDto(orderService.getSingleOrder(id));
    }

    @PostMapping("/orders")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PutMapping("/orders")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Order editOrder(@RequestBody Order order){
        return orderService.editOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteOrder(@PathVariable long id){
        orderService.deleteOrder(id);
    }
}
