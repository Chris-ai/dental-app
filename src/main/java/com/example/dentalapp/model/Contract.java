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
@Entity(name = "Umowa")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "contract_id")
    private List<Employee> employeeList;

    public Contract(String name) {
        this.type = name;
        employeeList = new ArrayList<>();
    }
}
