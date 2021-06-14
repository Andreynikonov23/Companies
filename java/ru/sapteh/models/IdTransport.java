package ru.sapteh.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "id_transport")
public class IdTransport {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "id_transport")
    private int idTransport;

    @Override
    public String toString() {
        return String.format(String.valueOf(idTransport));
    }
}
