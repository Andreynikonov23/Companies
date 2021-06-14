package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Trailer_type")
public class TrailerType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany (mappedBy = "trailerType")
    Set<Trailer> trailers;

    @Override
    public String toString() {
        return String.format(name);
    }
}
