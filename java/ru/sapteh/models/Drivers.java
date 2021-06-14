package ru.sapteh.models;

import lombok.*;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Drivers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fio;
    @Column
    private String phone;
    @Column
    private String email;

    @OneToMany (mappedBy = "drivers")
    Set<Orders> orders;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "license_id")
    private License license;
    @Override
    public String toString() {
        return String.format(fio);
    }
}
