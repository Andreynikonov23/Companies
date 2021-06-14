package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fio;
    @Column
    private String phone;
    @Column
    private String email;

    @OneToMany (mappedBy = "client")
    Set<Invoice> invoices;
    @OneToMany (mappedBy = "client")
    Set<Consignee> consignees;

    @Override
    public String toString() {
        return String.format(fio);
    }
}
