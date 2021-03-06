package com.example.dentalapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Entity(name = "Wizyta")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date DateOfVisit;
    private String comment;
    @ManyToOne(targetEntity = Patient.class,fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL)
    private Surgery surgery;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="visit_id")
    private List<Tooth> teeth;

    public Visit(Date DateOfVisit, String comment, Patient patient, Employee employee, Surgery surgery){
        this.DateOfVisit = DateOfVisit;
        this.comment = comment;
        this.patient = patient;
        this.employee = employee;
        this.surgery = surgery;
        this.teeth = new ArrayList<>();
    }

}