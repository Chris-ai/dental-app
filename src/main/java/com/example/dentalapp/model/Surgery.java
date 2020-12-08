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
@Entity(name = "Zabieg")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "surgery_id")
    private List<Medicine> medicineList;

    public Surgery(String name, String description){
        this.name = name;
        this.description = description;
        medicineList = new ArrayList<>();
    }
}
