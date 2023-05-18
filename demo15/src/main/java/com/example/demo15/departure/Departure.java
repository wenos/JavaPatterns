package com.example.demo15.departure;

import com.example.demo15.postoffice.PostOffice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "departures")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;

    @Column(name = "departure_date")
    private String departureDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_id")
    private List<PostOffice> postOffice;
}