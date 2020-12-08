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
@Entity(name = "Nieobecny")
public class MissingPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date beggingDate;
    private Date comebackDate;
    @ManyToOne
    private Leave leave;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Employee employee;

    public MissingPerson(Date begging, Date comeback, Leave leave, Employee employee) {
        this.beggingDate = begging;
        this.comebackDate = comeback;
        this.leave = leave;
        this.employee = employee;
    }
}