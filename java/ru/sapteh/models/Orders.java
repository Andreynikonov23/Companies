package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Orders {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String address;
    @Column
    private int distance;
    @Column  (name = "date_sending")
    private LocalDate dateSending;
    @Column
    private int cost;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "Transport_id")
    private Transport transport;
    @OneToMany (mappedBy = "orders")
    Set<Invoice> invoices;
    @OneToMany (mappedBy = "orders")
    Set<Waybill> waybills;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "managers_id")
    private Managers managers;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "trailer_id")
    private Trailer trailer;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "drivers_id")
    private Drivers drivers;
}
