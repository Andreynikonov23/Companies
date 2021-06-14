package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

//Анотации Lombok
@Getter
@Setter
@NoArgsConstructor
//Обьявление этого класса сущностью
@Entity
//Создает из этой модели таблицу
@Table
public class Cargo {
    //Атрибуты
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private double weight;
    @Column  (name = "overall_dimensions")
    private String overallDimensions;
    @Column
    private int quantity;
    @Column
    private String packages;
    @Column
    private int cost;

    //Связи
    @OneToMany (mappedBy = "cargo")
    Set<Invoice> invoices;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "Cargo_type_id")
    private CargoType cargoType;
}
