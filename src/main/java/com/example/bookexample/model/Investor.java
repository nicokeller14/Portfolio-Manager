package com.example.bookexample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Investor {

        @Id
        @GeneratedValue
        private long investorId;

        private String firstName;
        private String lastName;
        private String email;
        private String city;
        private String country;
        private String timeZone;

        @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Portfolio> portfolios;
}
