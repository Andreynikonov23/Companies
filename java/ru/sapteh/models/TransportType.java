package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Transport_type")
public class TransportType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "transportType")
    Set<Transport> transports;

    @Override
    public String toString() {
        return String.format(name);
    }
}
