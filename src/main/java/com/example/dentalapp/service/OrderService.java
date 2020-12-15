package com.example.dentalapp.service;

import com.example.dentalapp.model.Order;
import com.example.dentalapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getSingleOrder(long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order editOrder(Order order,long orderId) {
        Order orderEdited = orderRepository.findById(orderId);
        orderEdited.setAmount(order.getAmount());
        orderEdited.setOrderDate(order.getOrderDate());
        orderEdited.setPrice(order.getPrice());
        orderEdited.setMedicine(order.getMedicine());

        return orderEdited;
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
