package com.example.dentalapp.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Pracownik")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Position position;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Contract contract;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Account account;
    private String name;
    private String surname;
    private String pesel;
    private Date dateOfEmployment;
    private String email;
    private long phoneNumber;
    private float salary;

    public Employee(String name,String surname,String pesel, Date dateOfEmployment, String email, int phoneNumber,
                    Position position, float salary,Contract contract, Account account) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.dateOfEmployment = dateOfEmployment;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
        this.account = account;
        this.contract = contract;
    }
}