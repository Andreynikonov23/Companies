package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "Consignee")
public class Consignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fio;
    @Column
    private String phone;
    @Column
    private String email;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "Client_id")
    private Client client;
    @OneToMany (mappedBy = "consignee", fetch = FetchType.EAGER)
    Set<Invoice> invoices;
}
