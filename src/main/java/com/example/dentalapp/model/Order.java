package com.example.dentalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Zamowienie")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date orderDate;
    private double amount;
    private float price;
    @ManyToOne(targetEntity = Medicine.class,fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn
    private Medicine medicine;

    public Order(Date orderDate, double amount, float price,Medicine medicine){
        this.orderDate = orderDate;
        this.amount = amount;
        this.price = price;
        this.medicine = medicine;
    }
}
