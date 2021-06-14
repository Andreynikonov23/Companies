package ru.sapteh.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = "license")
public class License {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "series_number")
    private String seriesNumber;
    @Column
    private String category;
    @Column (name = "date_issue")
    private LocalDate dateIssue;
    @Column (name = "end_date")
    private LocalDate endDate;
    @Column
    private String gibdd;
    @Column (name = "place_issue")
    private String placeIssue;

    @OneToMany (mappedBy = "license")
    Set<Drivers> drivers;

    @Override
    public String toString() {
        return String.format(seriesNumber);
    }
}
