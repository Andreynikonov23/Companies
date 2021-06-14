package ru.sapteh.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table
public class Managers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fio;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String login;
    @Column
    private String password;

    @OneToMany (mappedBy = "managers")
    private Set<Orders> orders;

    @Override
    public String toString() {
        return String.format(fio);
    }
}
