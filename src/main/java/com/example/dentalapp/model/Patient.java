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
@Entity(name = "Pacjent")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long cardId;
    private String name;
    private String surname;
    private String pesel;
    private Date registerDate;
    private Date bornDate;
    private String city;
    private String address;
    private String email;
    private String zipCode;
    private long phoneNumber;
    private String extra_info;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private List<Visit> visitList;

    public Patient(String name, String surname, String pesel, Date registerDate, Date bornDate,
                   String city, String address, String email, String zipCode, int phoneNumber, String extra_info) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.bornDate = bornDate;
        this.registerDate = registerDate;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.extra_info = extra_info;
        this.visitList = new ArrayList<>();
    }
}
