package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Cat {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    private List<Owner> owners = new ArrayList<>();

    public void addOwner(Owner owner){
        owners.add(owner);
    }
}