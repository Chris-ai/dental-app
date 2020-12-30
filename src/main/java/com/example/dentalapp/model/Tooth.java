package com.example.dentalapp.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Zab")
public class Tooth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int number;
    @ManyToOne
    private Visit visit;

    public Tooth(String name){
        this.name = name;
    }
}
