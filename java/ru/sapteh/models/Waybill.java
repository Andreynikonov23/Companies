package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Waybill {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int series;
    @Column
    private int number;
    @Column  (name = "Дата")
    private Date date;
    @Column
    private String path;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "Orders_id")
    private Orders orders;
    @ManyToMany
            @JoinTable (name = "Waybill_has_Schedule", joinColumns = @JoinColumn (name = "Waybill_id"), inverseJoinColumns = @JoinColumn(name = "Schedule_id"))
    Set<Schedule> schedules;
}
