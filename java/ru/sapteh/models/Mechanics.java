package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "mechanics")
public class Mechanics {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fio;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String address;

    @Override
    public String toString() {
        return String.format(fio);
    }
}
