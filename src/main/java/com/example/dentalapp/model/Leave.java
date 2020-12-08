package com.example.dentalapp.model;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Zwolnienie")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private boolean isPayed;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="leave_id")
    private List<MissingPerson> missingPeople;

    public Leave(String type, boolean isPayed){
        this.type = type;
        this.isPayed = isPayed;
        this.missingPeople = new ArrayList<>();
    }

    public boolean getIsPayed() {
        return this.isPayed;
    }
}
