package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Invoice {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "Client_id")
    private Client client;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "Transport_id")
    private Transport transport;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "Cargo_id")
    private Cargo cargo;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "Orders_id")
    private Orders orders;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "Consignee_id")
    private Consignee consignee;
}
