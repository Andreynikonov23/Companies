package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cargo_type")
public class CargoType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "cargoType")
    Set<Cargo> cargos;

    @Override
    public String toString() {
        return String.format(name);
    }
}
