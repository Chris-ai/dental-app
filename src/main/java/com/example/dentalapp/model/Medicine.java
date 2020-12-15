package com.example.dentalapp.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Lek")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double amount;
    private String description;
    @ManyToOne(targetEntity = Surgery.class,fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    private Surgery surgery;
    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(name = "medicine_id")
    private List<Order> orderList;

    public Medicine(String name, double amount, String description) {
        this.name = name;
        this.amount = amount;
        this.description = description;
        orderList = new ArrayList<>();
    }
}
