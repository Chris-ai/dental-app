package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class OrderDto {
    private long id;
    private Date orderDate;
    private double amount;
    private float price;
    private String medicineName;
}

