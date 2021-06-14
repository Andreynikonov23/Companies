package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Trailer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String mark;
    @Column  (name = "gos_number")
    private String gosNumber;
    @Column  (name = "garage_number")
    private String garageNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "Trailer_type_id")
    private TrailerType trailerType;
    @OneToMany (mappedBy = "trailer")
    Set<Orders> orders;

    @Override
    public String toString() {
        return String.format(mark);
    }
}
