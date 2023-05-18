package com.example.demo15.postoffice;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post_office")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city_name")
    private String cityName;
}