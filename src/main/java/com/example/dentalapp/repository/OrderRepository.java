package com.example.dentalapp.repository;

import com.example.dentalapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("select z from Zamowienie z left join fetch z.medicine")
    List<Order> findAll();
    Order findById(long id);
}
