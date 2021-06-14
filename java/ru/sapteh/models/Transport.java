package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Transport {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String mark;
    @Column
    private String pts;
    @Column
    private String photo;
    @Column (name = "date_to")
    private LocalDate dateTO;
    @Column (name = "fuel_consumption")
    private String fuelConsumption;
    @Column (name = "gos_number")
    private String gosNumber;


    @OneToMany(mappedBy = "transport")
    Set<Invoice> invoices;
    @OneToMany (mappedBy = "transport")
    Set<Orders> orders;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "Transport_type_id")
    private TransportType transportType;

    @Override
    public String toString() {
        return String.format("%s", mark);
    }
}
